import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SnowflakeCatcher extends PApplet {

int numFlakes = 200;
SnowFlake[] snow = new SnowFlake[numFlakes];

public void setup()
{
  background(0);
  rectMode(CENTER);
  size(500,500);
  for(int i=0; i < numFlakes; i++)
  {
    snow[i] = new SnowFlake();
  }
}
public void draw()
{
  fill(0);
  rect(250, 750,500 , 250);
  for(int i=0; i < numFlakes; i++)
  {
    snow[i].erase();
    snow[i].show();
    snow[i].move();
    snow[i].wrap();
    snow[i].lookDown();
  }
}
public void mouseDragged()
{
  if(mouseButton == LEFT)
  {
    fill(255,0,0);
    rect(mouseX,mouseY,15,15);
  }
  if(mouseButton == RIGHT)
  {
    fill(0,0,0);
    rect(mouseX,mouseY,20,20);
  }
}

class SnowFlake
{
  int x,y,changeY,changeX;
  SnowFlake()
  {
    x = (int)(Math.random() * 500);
    y = -(int)(Math.random() * 1000);
    changeY = 3;
    changeX = 1;
  }
  public void show()
  {
    noStroke();
    fill(255);
    ellipse(x,y,10,10);
  }
  public void lookDown()
  {
    if(y>5 && y <490)
    {
      if(get(x,y+7) != color(0,0,0))
      {
        changeY = 0;
        changeX = 0;
      }
      else 
      {
        changeY = 3;
      }
    }
  }
  public void erase()
  {
    fill(0);
    ellipse(x,y-changeY,12,12);
  }
  public void move()
  {
    y = y + changeY;
    x = x + changeX;
  }
  public void wrap()
  {
    if(y>500)
    {
      fill(0);
      ellipse(x,y-3,12,12);
      y = -(int)(Math.random() * 1000);
      x = (int)(Math.random() * 500);
    }
  }
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SnowflakeCatcher" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
