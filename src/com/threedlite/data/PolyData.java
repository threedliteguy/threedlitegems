package com.threedlite.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.Context;

import com.threedlite.exotics.R;
import com.threedlite.model.ThreeDPoint;
import com.threedlite.model.ThreeDSprite;

public class PolyData {

	public static ThreeDSprite get(int n, Context context) {
		
	
		// See http://www.georgehart.com/virtual-polyhedra/netlib-info.html
		
		ThreeDSprite result = null; 
		
		switch(n) {
		case 0:
		result = load(R.raw.d0, context);
		break;
		case 1:
		result = load(R.raw.d1, context);
		break;
		case 2:
		result = load(R.raw.d2, context);
		break;
		case 3:
		result = load(R.raw.d3, context);
		break;
		case 4:
		result = load(R.raw.d4, context);
		break;
//		case 5:
//		result = load(R.raw.d5, context); // requires polygon cutting
//		break;
//		case 6:
//		result = load(R.raw.d6, context); // requires polygon cutting
//		break;
//		case 7:
//		result = load(R.raw.d7, context); // requires polygon cutting
//		break;
//		case 8:
//		result = load(R.raw.d8, context); // requires polygon cutting
//		break;
//		case 9:
//		result = load(R.raw.d9, context); // no solid
//		break;
//		case 10:
//		result = load(R.raw.d10, context); // no solid
//		break;
//		case 11:
//		result = load(R.raw.d11, context); // no solid
//		break;
//		case 12:
//		result = load(R.raw.d12, context); // no solid
//		break;
//		case 13:
//		result = load(R.raw.d13, context); // no solid
//		break;
//		case 14:
//		result = load(R.raw.d14, context); // no solid
//		break;
//		case 15:
//		result = load(R.raw.d15, context); // no solid
//		break;
//		case 16:
//		result = load(R.raw.d16, context); // no solid
//		break;
//		case 17:
//		result = load(R.raw.d17, context); // no solid
//		break;
//		case 18:
//		result = load(R.raw.d18, context); // no solid
//		break;
//		case 19:
//		result = load(R.raw.d19, context); // no solid
//		break;
//		case 20:
//		result = load(R.raw.d20, context); // no solid
//		break;
//		case 21:
//		result = load(R.raw.d21, context); // no solid
//		break;
		case 22:
		result = load(R.raw.d22, context);
		break;
		case 23:
		result = load(R.raw.d23, context);
		break;
		case 24:
		result = load(R.raw.d24, context);
		break;
		case 25:
		result = load(R.raw.d25, context);
		break;
		case 26:
		result = load(R.raw.d26, context);
		break;
		case 27:
		result = load(R.raw.d27, context);
		break;
		case 28:
		result = load(R.raw.d28, context);
		break;
		case 29:
		result = load(R.raw.d29, context);
		break;
		case 30:
		result = load(R.raw.d30, context);
		break;
		case 31:
		result = load(R.raw.d31, context);
		break;
//		case 32:
//		result = load(R.raw.d32, context); // no solid
//		break;
		case 33:
		result = load(R.raw.d33, context);
		break;
		case 34:
		result = load(R.raw.d34, context);
		break;
		case 35:
		result = load(R.raw.d35, context);
		break;
		case 36:
		result = load(R.raw.d36, context);
		break;
		case 37:
		result = load(R.raw.d37, context);
		break;
		case 38:
		result = load(R.raw.d38, context);
		break;
		case 39:
		result = load(R.raw.d39, context);
		break;
		case 40:
		result = load(R.raw.d40, context);
		break;
		case 41:
		result = load(R.raw.d41, context);
		break;
		case 42:
		result = load(R.raw.d42, context);
		break;
		case 43:
		result = load(R.raw.d43, context);
		break;
		case 44:
		result = load(R.raw.d44, context);
		break;
		case 45:
		result = load(R.raw.d45, context);
		break;
		case 46:
		result = load(R.raw.d46, context);
		break;
		case 47:
		result = load(R.raw.d47, context);
		break;
		case 48:
		result = load(R.raw.d48, context);
		break;
		case 49:
		result = load(R.raw.d49, context);
		break;
		case 50:
		result = load(R.raw.d50, context);
		break;
		case 51:
		result = load(R.raw.d51, context);
		break;
		case 52:
		result = load(R.raw.d52, context);
		break;
		case 53:
		result = load(R.raw.d53, context);
		break;
		case 54:
		result = load(R.raw.d54, context);
		break;
		case 55:
		result = load(R.raw.d55, context);
		break;
		case 56:
		result = load(R.raw.d56, context);
		break;
		case 57:
		result = load(R.raw.d57, context);
		break;
		case 58:
		result = load(R.raw.d58, context);
		break;
		case 59:
		result = load(R.raw.d59, context);
		break;
		case 60:
		result = load(R.raw.d60, context);
		break;
		case 61:
		result = load(R.raw.d61, context);
		break;
		case 62:
		result = load(R.raw.d62, context);
		break;
		case 63:
		result = load(R.raw.d63, context);
		break;
		case 64:
		result = load(R.raw.d64, context);
		break;
		case 65:
		result = load(R.raw.d65, context);
		break;
//		case 66:
//		result = load(R.raw.d66, context); // missing data
//		break;
//		case 67:
//		result = load(R.raw.d67, context); // missing data
//		break;
//		case 68:
//		result = load(R.raw.d68, context); // missing data
//		break;
//		case 69:
//		result = load(R.raw.d69, context); // missing data
//		break;
//		case 70:
//		result = load(R.raw.d70, context); // missing data
//		break;
		case 71:
		result = load(R.raw.d71, context);
		break;
		case 72:
		result = load(R.raw.d72, context);
		break;
		case 73:
		result = load(R.raw.d73, context);
		break;
		case 74:
		result = load(R.raw.d74, context);
		break;
		case 75:
		result = load(R.raw.d75, context);
		break;
		case 76:
		result = load(R.raw.d76, context);
		break;
		case 77:
		result = load(R.raw.d77, context);
		break;
		case 78:
		result = load(R.raw.d78, context);
		break;
		case 79:
		result = load(R.raw.d79, context);
		break;
		case 80:
		result = load(R.raw.d80, context);
		break;
		case 81:
		result = load(R.raw.d81, context);
		break;
		case 82:
		result = load(R.raw.d82, context);
		break;
		case 83:
		result = load(R.raw.d83, context);
		break;
		case 84:
		result = load(R.raw.d84, context);
		break;
		case 85:
		result = load(R.raw.d85, context);
		break;
		case 86:
		result = load(R.raw.d86, context);
		break;
		case 87:
		result = load(R.raw.d87, context);
		break;
		case 88:
		result = load(R.raw.d88, context);
		break;
		case 89:
		result = load(R.raw.d89, context);
		break;
		case 90:
		result = load(R.raw.d90, context);
		break;
		case 91:
		result = load(R.raw.d91, context);
		break;
		case 92:
		result = load(R.raw.d92, context);
		break;
		case 93:
		result = load(R.raw.d93, context);
		break;
		case 94:
		result = load(R.raw.d94, context);
		break;
		case 95:
		result = load(R.raw.d95, context);
		break;
		case 96:
		result = load(R.raw.d96, context);
		break;
		case 97:
		result = load(R.raw.d97, context);
		break;
		case 98:
		result = load(R.raw.d98, context);
		break;
		case 99:
		result = load(R.raw.d99, context);
		break;
		case 100:
		result = load(R.raw.d100, context);
		break;
		case 101:
		result = load(R.raw.d101, context);
		break;
		case 102:
		result = load(R.raw.d102, context);
		break;
		case 103:
		result = load(R.raw.d103, context);
		break;
		case 104:
		result = load(R.raw.d104, context);
		break;
		case 105:
		result = load(R.raw.d105, context);
		break;
		case 106:
		result = load(R.raw.d106, context);
		break;
		case 107:
		result = load(R.raw.d107, context);
		break;
//		case 108:
//		result = load(R.raw.d108, context); // missing data
//		break;
		case 109:
		result = load(R.raw.d109, context);
		break;
		case 110:
		result = load(R.raw.d110, context);
		break;
		case 111:
		result = load(R.raw.d111, context);
		break;
		case 112:
		result = load(R.raw.d112, context);
		break;
		case 113:
		result = load(R.raw.d113, context);
		break;
		case 114:
		result = load(R.raw.d114, context);
		break;
//		case 115:
//		result = load(R.raw.d115, context); // missing data
//		break;
		case 116:
		result = load(R.raw.d116, context);
		break;
		case 117:
		result = load(R.raw.d117, context);
		break;
		case 118:
		result = load(R.raw.d118, context);
		break;
		case 119:
		result = load(R.raw.d119, context);
		break;
		case 120:
		result = load(R.raw.d120, context);
		break;
		case 121:
		result = load(R.raw.d121, context);
		break;
		case 122:
		result = load(R.raw.d122, context);
		break;
		case 123:
		result = load(R.raw.d123, context);
		break;
		case 124:
		result = load(R.raw.d124, context);
		break;
		case 125:
		result = load(R.raw.d125, context);
		break;
		case 126:
		result = load(R.raw.d126, context);
		break;
		case 127:
		result = load(R.raw.d127, context);
		break;
		case 128:
		result = load(R.raw.d128, context);
		break;
		case 129:
		result = load(R.raw.d129, context);
		break;
		case 130:
		result = load(R.raw.d130, context);
		break;
		case 131:
		result = load(R.raw.d131, context);
		break;
		case 132:
		result = load(R.raw.d132, context);
		break;
		case 133:
		result = load(R.raw.d133, context);
		break;
		case 134:
		result = load(R.raw.d134, context);
		break;
		case 135:
		result = load(R.raw.d135, context);
		break;
		case 136:
		result = load(R.raw.d136, context);
		break;
		case 137:
		result = load(R.raw.d137, context);
		break;
		case 138:
		result = load(R.raw.d138, context);
		break;
		case 139:
		result = load(R.raw.d139, context);
		break;
		case 140:
		result = load(R.raw.d140, context);
		break;
		case 141:
		result = load(R.raw.d141, context);
		break;

		default:
		throw new RuntimeException("No data.");
		
		}

		normalize(result);

//		String message = "v="+result.getVertexCount()+" f="+result.getFaceCount()+" ";
//		for (int i = 0; i < result.getVertexCount();i++) message = message + result.getVertex(i);
//		for (int i = 0; i < 10; i++) Toast.makeText(context, new StringBuffer(message), Toast.LENGTH_LONG).show();
		
		return result;
		
	}
	
	private static void normalize(ThreeDSprite o) {
		
		if (o == null) return;
		
		// Renumber faces
		int lowvertex = Integer.MAX_VALUE;
		for (int j = 0; j < o.getFaceCount(); j++) {
			int[] f = o.getFace(j);
			for (int k = 0; k < f.length;k++) {
				if (f[k] < lowvertex) {
					lowvertex = f[k];
				}
			}
		}
		for (int j = 0; j < o.getFaceCount(); j++) {
			int[] f = o.getFace(j);
			for (int k = 0; k < f.length;k++) {
				f[k] = f[k] - lowvertex;
			}
		}
		
		// Eliminate unreferenced vertices 
		for (int i = 0; i < lowvertex; i++) o.vertexes.remove(0);
		
	
		// Center
		double sx = 0;
		double sy = 0;
		double sz = 0;
		for (int i = 0; i < o.getVertexCount();i++) {
			ThreeDPoint p = o.getVertex(i);
			sx += p.x;
			sy += p.y;
			sz += p.z;
		}
		sx = sx / (o.getVertexCount()*1d);
		sy = sy / (o.getVertexCount()*1d);
		sz = sz / (o.getVertexCount()*1d);
		
		for (int i = 0; i < o.getVertexCount();i++) {
			ThreeDPoint p = o.getVertex(i);
			p.x = (p.x-sx);
			p.y = (p.y-sy);
			p.z = (p.z-sz);
		}	
		
		
		// Size
		double mx = 0;
		double my = 0;
		double mz = 0;
		for (int i = 0; i < o.getVertexCount();i++) {
			ThreeDPoint p = o.getVertex(i);
			if (p.x > mx) mx = p.x;
			if (p.y > my) my = p.y;
			if (p.z > mz) mz = p.z;
		}	
		double stretch = 300d / Math.max(Math.max(mx, my), mz);
		for (int i = 0; i < o.getVertexCount();i++) {
			ThreeDPoint p = o.getVertex(i);
			p.x = p.x * stretch;
			p.y = p.y * stretch;
			p.z = p.z * stretch;
		}	
	
		
	}

	// Parse netlib format
	private static ThreeDSprite load(int resourceId, Context context) {

		ThreeDSprite o = new ThreeDSprite();
		o.center = new ThreeDPoint(0, 0, 0);

		InputStream is = context.getResources().openRawResource(resourceId);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String readLine = null;
		try {

			int readingVertices = -1;
			int readingFaces = -1;
			while ((readLine = br.readLine()) != null) {

				if (readLine.startsWith(":")) {
					readingVertices = -1;
					readingFaces = -1;
				}
				if (readLine.equals(":solid")) {
					readingFaces = 0;
				}
				if (readLine.equals(":vertices")) {
					readingVertices = 0;
				}
				if (readingFaces > -1) {
					if (readingFaces > 1) {
						String[] sa = readLine.split("\\s");
						int[] f = new int[sa.length-1];
						for (int i = 1; i < sa.length; i++) f[i-1] = Integer.parseInt(sa[i]);
						o.addFace(f);
					}
					readingFaces++;
				}
				if (readingVertices > -1) {
					if (readingVertices > 1) {
						String[] sa = readLine.split("\\s");
						double[] v = new double[sa.length];
						for (int i = 0; i < sa.length; i++) {
							String s = sa[i];
							int ind = s.indexOf("[");
							if (ind > -1) s = s.substring(0, ind);
							v[i] = Double.parseDouble(s);
						}
						o.addVertex(v[0], v[1], v[2]);
					}
					readingVertices++;
				}

			}
			is.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return o;

	}

}
