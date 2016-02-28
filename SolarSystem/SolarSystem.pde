void setup()
{
   size(500, 500, P3D);
   
  
}


void draw()
{
  int n=0;
  int m=0;
  

   
   //Sun
   noStroke();
   rotateY(n*-PI/6*0.05);
   fill(255, 150, 10);
   sphere(50);
   
   
   //Earth Path
   stroke(255, 255, 10, 50);
   strokeWeight(5);
   noFill();
   rotateX(-PI/2);
   ellipse(0, 0, 2*width/3, 2*width/3);
   n++;
   
   
   //Earth
   noStroke();
   fill(10, 150, 255);
   translate(width/3, 0, 0);
   rotateZ(radians(m));
   
}