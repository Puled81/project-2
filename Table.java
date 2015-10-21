//Making a Scene
//Drake P  9/9/15 CST 112

/// GLOBALS:  coordinates, speed, etc.
float x, y;       // Position of Hero
float dx, dy;     // Speed.
float horizon;
float sunX, sunY;
float X, Y;        //Monster 1 position
float DX, DY;       // monster 1 speed
float coinx, coiny;

float score;
float top,bottom,right,left;

//// SETUP:  window size, initialization (start in middle of screen).
void setup() {
  size( 700,700);
  horizon=  height/4;
  x=  170;
  y=  125;
  dx= 0;
  dy= 0;
  X= random(0,700);
  Y= random(301,700);
  DX= random(-1,+1);
  DY= random(-1,+1);
  coinx= random(400,680);
  coiny= random(450,680);
  score= 50;
  top= 0;
  bottom= 700;
  right= 700;
  left= 0;
  //
  reset();
}
void reset() {
  x=  170;
  y=  125;
  dx= .75;
  dy= .75;
  X= random(0,680);
  Y= random(301,680);
  DX= random(-3,+3);
  DY= random(-3,+3);
  coinx= random(400,680);
  coiny= random(450,680);
  score-= 50;


}{
  /// start sun
  sunX=width*3/4;
  sunY=100;
  
}

//// NEXT FRAME:  scene, action, show.
void draw() {
  collisions();
  //// SCENE:  sky, sun, tree, house, etc.
  background( 100,200,250 );                // sky
  fill( 255,255,0 );
  sunX= (sunX+1) % (width+150);
 
  ellipse( sunX,sunY, 40,40 );    // sun
  
  fill( 100,200,100 );
  rect( 0,horizon, width,height*3/4 );      // grass.
  
  triangle(550,150,600,150,575,100);
  fill(139,80,13);
  rect(568,150,15,25);
  
  
  fill(255,0,0);
  rect( 150,75, 90,100);  // house
  fill(139,80,13);
  rect(200,125,25,50);
  fill(0);
  triangle(151,75,240,75,196,20);
  fill(255);
  rect(155,90,30,30);
  rect(205,90,30,30);
  
  //Scoreing
  textSize(20);
  fill(0);
  text("Score",50,50);
  text(score,100,50);
  
                                      

  fill(0);                //INFO
  textSize(16);
  text( "Drake", 10,height-20 );
  text("'r' to restart",175,height-20);
  text("'q' to quit",400,height-20);
  textSize(12);  
                                            
 //// ACTION:  move (x,y) coordinates
 
 dx=0; 
 dy=0;
  
 if (keyPressed && (key == 'W' || key == 'w') ){
      dy = -1; 
 }
 
 
   
 if (keyPressed) {
    if (key == 'S' || key == 's') 
    {
      dy = +1; 
    }
 }

 
 
  if (keyPressed) {
    if (key == 'A' || key == 'a') {
      dx = -1; 
    }
 }
 
 if (keyPressed) {
   if (key == 'D' || key == 'd') {
    dx = 1; }
 }
 
 X= X + DX;
 Y= Y + DY;
 
 {
   X += DX; if( X<left || X+25 >right)DX *= -1;
   Y += DY; if( Y-15< horizon ||Y+50>bottom) DY *= -1;
 }
 
    
  
  //Hero
  fill(50,80,150);    // body
  rect( x+3,y, 25,50,10 );
  fill(238,206,179);   // head
  ellipse(x+15,y-11,20,20);  
  fill(0,0,155);    //eyes
  ellipse(x+12,y-13,3,3);
  ellipse(x+18,y-13,3,3);
  fill(255,255,0);
  stroke(0);
  fill(255);
  textSize(9);
  text( "Jimmy", x+3,y+30 );
  
  x += dx;
  y += dy;
  
    //Monster 1
  rect(X,Y,30,70,10);
  ellipse(X+15,Y-15,35,35);

    //Coin (gold)
  fill(255,255,0);
  ellipse(coinx,coiny,10,10);
}

void collisions(){
  //if( 120 < X < horizon-50) { DX = -DX;}
  if( dist ( x,y-15,X,Y-60) < 30) {reset();}
  if( dist ( x,y+15,X,Y+70) < 30) {reset();}
}

//////// HANDLERS:  mouse clicks, keys
void mousePressed() {
  x=  mouseX;                             // Set (x,y) to mouse
  y=  mouseY;
  //
 // dx=  random( -6, +6 );                  // random speed.
  //dy=  random( -4, +4 );
}

void keyPressed() {
  if (key == 'q') {
    exit();                           // press 'q' key to QUIT.
  }                                   // press 'r' to RESET
  {
    if (key == 'r') {   
      reset();
    }}
}
   
