int numFlakes = 200;
SnowFlake[] snow = new SnowFlake[numFlakes];

void setup()
{
  background(0);
  rectMode(CENTER);
  size(500,500);
  for(int i=0; i < numFlakes; i++)
  {
    snow[i] = new SnowFlake();
  }
}
void draw()
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
void mouseDragged()
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
  int x,y,changeY;
  SnowFlake()
  {
    x = (int)(Math.random() * 500);
    y = -(int)(Math.random() * 1000);
    changeY = 3;
  }
  void show()
  {
    noStroke();
    fill(255);
    ellipse(x,y,10,10);
  }
  void lookDown()
  {
    if(y>5 && y <490)
    {
      if(get(x,y+7) != color(0,0,0))
      {
        changeY = 0;
      }
      else 
      {
        changeY = 3;
      }
    }
  }
  void erase()
  {
    fill(0);
    ellipse(x,y-changeY,12,12);
  }
  void move()
  {
    y = y + changeY;
  }
  void wrap()
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


