/*
 * Some code taken from http://ninjacave.com/slickutil1
 */

package game;

import java.io.IOException;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
 
public class Textures {
	
	public static String IMAGE1 = "trans_rights.png";
 
	/** The texture that will hold the image details */
	public static Texture hatsune;
	public static Texture sky;
	public static Texture bee;
 
	/**
	 * Start the example
	 */
//	public void start() {
//		initGL(400,400);
//		init();
// 
//		while (true) {
//			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
//			render();
// 
//			Display.update();
//			Display.sync(100);
// 
//			if (Display.isCloseRequested()) {
//				Display.destroy();
//				System.exit(0);
//			}
//		}
//	}
 
	/**
	 * Initialise the GL display
	 * 
	 * @param width The width of the display
	 * @param height The height of the display
	 */
	public static void initGL(int width, int height) {
		GL11.glEnable(GL11.GL_TEXTURE_2D);               
 
		GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);          
 
        	// enable alpha blending
        	GL11.glEnable(GL11.GL_BLEND);
        	GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
 
        	GL11.glViewport(0,0,width,height);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
 
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, width, height, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
	}
 
	/**
	 * Initialise resources
	 */
	public static Texture load(String img, String type) throws IOException {
		Texture texture;
			texture = TextureLoader.getTexture(type, ResourceLoader.getResourceAsStream("res/" + img));
			System.out.println("Texture loaded: "+ texture);
//			System.out.println(">> Image width: "+texture.getImageWidth());
//			System.out.println(">> Image height: "+texture.getImageHeight());
//			System.out.println(">> Texture width: "+texture.getTextureWidth());
//			System.out.println(">> Texture height: "+texture.getTextureHeight());
//			System.out.println(">> Texture ID: "+texture.getTextureID());
		return texture;
	}
	
	public static void init() {
		try {
			sky = load("sky.png", "PNG");
			bee = load("bee_and_puppycat.png", "PNG");
		}
		catch(IOException e) {
			System.out.println("Error in loading");
		}
		
	}
 
	/**
	 * draw a quad with the image on it
	 */
	public static void render(Texture texture, int x, int y) {
		Color.white.bind();
		texture.bind(); // or GL11.glBind(texture.getTextureID());
 
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0,0);
			GL11.glVertex2f(x, y);
			GL11.glTexCoord2f(1,0);
			GL11.glVertex2f(x + texture.getTextureWidth(),0);
			GL11.glTexCoord2f(1,1);
			GL11.glVertex2f(x + texture.getTextureWidth(), y + texture.getTextureHeight());
			GL11.glTexCoord2f(0,1);
			GL11.glVertex2f(x, y + texture.getTextureHeight());
		GL11.glEnd();
	}
	
	public static void render(Texture texture) {
		render(texture, 0, 0);
	}
	
	
 
	/**
	 * Main Class
	 */
	public static void main(String[] argv) {
//		Textures textureExample = new Textures();
//		textureExample.start();
	}
}