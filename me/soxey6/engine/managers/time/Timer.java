package me.soxey6.engine.managers.time;

import java.util.ArrayList;

import me.soxey6.engine.events.ticks.timer.TimerEvent;
import me.soxey6.engine.events.ticks.timer.TimerHandler;
import me.soxey6.engine.events.ticks.timer.TimerListener;
import me.soxey6.engine.main.Game;
import me.soxey6.engine.managers.event.EventManager;

public class Timer implements Runnable
{
	public boolean shouldStop = false;
	
	private static Timer timer;
	private ArrayList<Time> times;
	
	public Timer()
	{
		timer=this;
		this.times = new ArrayList<Time>();
	}
	
	public void tick()
	{
		long currentTime = System.currentTimeMillis();
		for(Time time:times)
			if(currentTime-time.getLastRun()>=time.getInterval())
			{
				Game.getGame().getPerformanceMonitor().tps++;
				EventManager.getEventManager().dispatch(new TimerEvent(time.getInterval()));
				time.setLastRun(currentTime);
				return;
			}
	}
	
	public void newTimer(Time time, TimerHandler timerHandler)
	{
		// Create a new timer and register the event
		EventManager.getEventManager().addListener(new TimerListener(timerHandler, new TimerEvent(time.getInterval())));
		for(Time curTime:getTimes())
		{
			if(curTime.getInterval()==time.getInterval())
				return;
		}
		times.add(time);
	}

	/**
	 * @return the timer
	 */
	public static Timer getTimer()
	{
		return timer;
	}

	/**
	 * @return the times
	 */
	public ArrayList<Time> getTimes()
	{
		return times;
	}

	/**
	 * @param timer the timer to set
	 */
	public static void setTimer(Timer timer)
	{
		Timer.timer = timer;
	}

	/**
	 * @param times the times to set
	 */
	public void setTimes(ArrayList<Time> times)
	{
		this.times = times;
	}

	@Override
	public void run() {
		while(!shouldStop)
		{
			tick();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
