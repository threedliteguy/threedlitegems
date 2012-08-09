package com.threedlite.exotics;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;

import com.threedlite.data.PolyData;
import com.threedlite.model.ThreeDObject;
import com.threedlite.model.ThreeDPoint;
import com.threedlite.model.ThreeDSprite;

public class ThreeDLiteExoticsWallpaper extends BaseWallpaper {

	private long startTime = System.currentTimeMillis();
	private long intervalNumber = 0; 

	private List<ThreeDSprite> objects = new ArrayList<ThreeDSprite>();

	private boolean initialized = false;

	public ThreeDLiteExoticsWallpaper() {
	}

	protected void reinit() {

		try {

			initialized = false;

			objects.clear();

			ThreeDSprite sprite = null;
			while (sprite == null) {
				int n = (int)Math.floor(Math.random()*142);
				try {
					sprite = PolyData.get(n, this);
					objects.add(sprite); 
					//				Toast.makeText(this, new StringBuffer(""+n), Toast.LENGTH_SHORT).show();
				} catch (Exception e) {
					//				String message = "Unable to parse shape "+n+" "+e.getMessage();
					//				Toast.makeText(this, new StringBuffer(message), Toast.LENGTH_SHORT).show();
				}
			}


			for (int i = 0; i < objects.size(); i++)
			{
				ThreeDSprite object = objects.get(i);
				object.translate(new ThreeDPoint(0, 0, i));
				object.velocity = new ThreeDPoint(rnd(6)-3, rnd(6)-3, 0);
				object.rotationDirection = new ThreeDPoint(rnd(1), rnd(1), rnd(1));
				object.rotationRate = ThreeDPoint.angleInRadians(rnd(5));
				object.color =  Color.rgb((int)rnd(255), (int)rnd(255), (int)rnd(255));
			}


			sortObjectArray(objects);  

		} catch (Exception e) {
			Log.e("threedlite", "exception - on  create: "+e.getMessage());
		}

		initialized = true;
	}

	double rnd(double r)
	{
		return Math.random()*r;
	}

	public void sortObjectArray(List<ThreeDSprite> a) {
		Collections.sort(a, new Comparator<ThreeDObject>() {

			public int compare(ThreeDObject lhs, ThreeDObject rhs) {
				return (int)(lhs.center.z - rhs.center.z);
			}

		});
	}

	
	private long getIntervalNumber(long time) {
		BigDecimal d = new BigDecimal(time);
		d = d.divide(new BigDecimal(1000 * 60f), BigDecimal.ROUND_DOWN);
		return d.longValue();
	}


	@Override
	protected void draw(Canvas canvas) {

		try {

			if (!initialized) return;
			
			long currentInterval = getIntervalNumber(System.currentTimeMillis());
			if (intervalNumber != currentInterval) {
				intervalNumber = currentInterval;
				reinit();
			}

			canvas.drawColor(Color.BLACK);

			sortObjectArray(objects);  

			int maxx = canvas.getWidth()/3;
			int maxy = canvas.getHeight()/3;
			ThreeDSprite o;
			for (int k = 0; k < objects.size(); k++)
			{
				o = objects.get(k); 

				o.move();

				o.paint(canvas);

				if (o.center.x > maxx)  o.velocity.x = -Math.abs(o.velocity.x);
				if (o.center.x < -maxx) o.velocity.x = Math.abs(o.velocity.x);
				if (o.center.y > maxy)  o.velocity.y = -Math.abs(o.velocity.y);
				if (o.center.y < -maxy) o.velocity.y = Math.abs(o.velocity.y);
				if (o.center.z > 2000)  o.velocity.z = -Math.abs(o.velocity.z);
				if (o.center.z < -2000) o.velocity.z = Math.abs(o.velocity.z);
			}

		} catch (Exception e) {
			Log.e("threedlite", "exception - on  draw: "+e.getMessage());
		}
	}

}