package com.threedlite.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Vector;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;

public class ThreeDSolid extends ThreeDObject
{
	public int color = Color.GRAY;
	public boolean transparent = false;
	static double rt = Math.PI/2.0;
	protected Vector<int[]> faces = new Vector<int[]>();

	public int [] getFace(int face)
	{
		return faces.elementAt(face);
	}

	public void setFace(int [] a, int face)
	{
		faces.setElementAt(a, face);
	}

	public void addFace(int [] face)
	{
		faces.addElement(face);
	}

	public int getFaceCount()
	{
		return faces.size();
	}



	public void joinFaces(double tolerance)             // Join faces together at edges by combining closeby vertexes // HACK efficiency for large objects - need this?
	{
		ThreeDPoint a = null;
		ThreeDPoint b = null;
		for (int i = 0; i < getVertexCount(); i++)
		{
			for (int j = 0; j < getVertexCount(); j++)
			{
				a = getVertex(i);
				b = getVertex(j);
				if ((i != j) && (a.near(b, tolerance)))
				{ 
					vertexes.removeElementAt(j);
					for (int k = 0; k < getFaceCount(); k++)  // re-reference faces
					{
						int [] face = getFace(k);
						for (int k1 = 0; k1 < face.length; k1++)
						{
							if (face[k1] == j) face[k1] = i;
							if (face[k1] > j) face[k1] = face[k1] - 1;
						}
					}

				}
			}
		}
	}

	public ThreeDPoint getSymmetricFaceCenter(int face)   // average vertexes to get center point
	{
		int [] theFace = getFace(face);
		ThreeDPoint ctr = new ThreeDPoint(0,0,0);  
		for (int j = 0; j < theFace.length; j++)
		{
			ctr.translate(getVertex(theFace[j]));  // translate() is a mutating method (faster than add()).
		}
		return ctr.scalarMultiply(1.0/theFace.length);
	}

	public ThreeDPoint getNormal(int [] face)   // Assumes face points are co-planar with at least 3 points.  
	{
		ThreeDPoint u = getVertex(face[1]).subtract(getVertex(face[0]));
		ThreeDPoint v = getVertex(face[2]).subtract(getVertex(face[0]));
		return u.crossProduct(v);
	}

	public void paint (Canvas canvas)
	{

		Integer[] sort = new Integer[getFaceCount()];
		for (int i = 0; i < sort.length; i++) sort[i] = i;

		// Painter's algorithm
		Arrays.sort(sort, new Comparator<Integer>() {

			public int compare(Integer lhs, Integer rhs) {
				return (int)Math.round(getCentroid(lhs).z - getCentroid(rhs).z);
			}

		});
		for (int k = 0; k < getFaceCount(); k++)
		{
			paintFace(getFace(sort[k]), canvas);
		}
	}

	public ThreeDPoint getCentroid(int face) {
		int[] f = getFace(face);
		double x = 0;
		double y = 0;
		double z = 0;
		for (int i = 0; i < f.length;i++) {
			ThreeDPoint v = getVertex(f[i]);
			x += v.x;
			y += v.y;
			z += v.z;
		}
		x = x/f.length;
		y = y/f.length;
		z = z/f.length;
		ThreeDPoint p = new ThreeDPoint(x,y,z);
		return p;
	}

	public void paintFace (int [] face, Canvas canvas)
	{
		ThreeDPoint normal = null; 
		double angle;

		if (transparent)
		{
			normal = null;
			angle = 0;
		} else {
			normal = getNormal(face);
			angle = normal.angleBetween(new ThreeDPoint(0, 0, screen.viewPointZ));
		}

		//      if (angle < rt)               // Face is visible.
		if (true)               // Face is visible.
		{
			Point p;
			int [] x = new int [face.length];
			int [] y = new int [face.length];
			for (int k = 0; k < face.length; k++)
			{
				p = screen.getScreenProjection(getVertex(face[k]));
				x[k] = p.x;
				y[k] = p.y;
			}

			Paint paint = new Paint();
			paint.setAntiAlias(true);
			if (transparent)
			{
				paint.setStyle(Paint.Style.STROKE);
				paint.setColor(color);
			} else {
				paint.setStyle(Paint.Style.FILL);
				paint.setColor(screen.light(normal, color)); 
			}

			Path path = new Path();
			path.moveTo(x[0],y[0]);
			for (int i = 0; i < face.length;i++) path.lineTo(x[i],y[i]);
			path.lineTo(x[0], y[0]);
			canvas.drawPath(path, paint);       

		}

	}

}
