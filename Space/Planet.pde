abstract class Planet
{
   float radius;
   float diameter;
   color colour; 
  
   Planet()
   {
      radius=0; 
      diameter=2*radius;
      colour=color(150, 150, 150);
   }
   
   abstract void display();
}
