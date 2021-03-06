String title=  "ELASTIC COLLISIONS";
String news=   "Use 'r' key to reset.";
String author=  "Drake";


float left, right, top, bottom;
float middle;
float score;

float cueX, cueY, cueDX, cueDY;
float redX, redY, redDX, redDY;
float yelX, yelY, yelDX, yelDY;
float bluX, bluY, bluDX, bluDY;

//// SETUP:  size and table
void setup() {
  size( 600, 400 );
  left=   50;
  right=  width-50;
  top=    100;
  bottom= height-50;
  middle= left + (right-left) / 2;
  score= 0;
  //
  reset();
 }
 void reset() {
   cueX=  left + (right-left) / 4;
   cueY=  top + (bottom-top) / 2;
   // Random positions.
   redX=  random( middle,right );   redY=  random( top, bottom );
   yelX=  random( middle,right );   yelY=  random( top, bottom );
   bluX=  random( middle,right );   bluY=  random( top, bottom );
   // Random speeds
   cueDX= (0);  cueDY= (0);
   redDX=  random( 1,3 );   redDY=  random( 1,3 );
   yelDX=  random( 1,3 );   redDY=  random( 1,3 );
   bluDX=  random( 1,3 );   bluDY=  random( 1,3 );
   score= 0;
 }
 //// NEXT FRAME:  table, bounce off walls, collisions, show all
void draw() {
  rect(550,40,20,40);
  background( 250,250,200 );
  rectMode( CORNERS );
  table( left, top, right, bottom );
  bounce();
  collisions();
  show();
  fill(0);
  textSize(12);
  text("Score:",450,40);
  text("Press 'L' to start cue ball",50,30);
  text("Press 'r' to reset table",50,50);
  textSize(20);
  text("1",redX-6,redY+6);     //numbers to balls
  text("2",yelX-6,yelY+6);
  text("3",bluX-6,bluY+6);
  textSize(12);
}
//// SCENE:  draw the table with walls
void table( float left, float top, float right, float bottom ) {
  fill( 50, 205, 50 );    // green pool table
  strokeWeight(20);
  stroke( 139, 69, 19 );      // Brown walls
  rect( left-25, top-25, right+25, bottom+25 );
  stroke(0);
  strokeWeight(1);
}

//// ACTION:  bounce off walls, collisions
void bounce() {
  redX += redDX;  if ( redX<left || redX>right ) redDX *= -1;
  redY += redDY;  if ( redY<top || redY>bottom ) redDY *=  -1;
  yelX += yelDX;  if ( yelX<left || yelX>right ) yelDX *= -1;
  yelY += yelDY;  if ( yelY<top || yelY>bottom ) yelDY *=  -1;
  bluX += bluDX;  if ( bluX<left || bluX>right ) bluDX *= -1;
  bluY += bluDY;  if ( bluY<top || bluY>bottom ) bluDY *=  -1;
  if (cueDX != 0);
  cueX += cueDX;  if ( cueX<left || cueX>right ) cueDX *= -1;
  cueY += cueDY;  if ( cueY<top || cueY>bottom ) cueDY *=  -1;
  
  
}
void collisions() {
  float tmp;
  // Swap velocities!
  if ( dist( redX,redY, yelX,yelY ) < 30 ) {
    tmp=yelDX;  yelDX=redDX;  redDX=tmp;
    tmp=yelDY;  yelDY=redDY;  redDY=tmp;
  }
  if ( dist( redX,redY, bluX,bluY) < 30 ) {
    tmp=bluDX;  bluDX=redDX;  redDX=tmp;
    tmp=bluDY;  bluDY=redDY;  redDY=tmp;
  }
  if ( dist( bluX,bluY, yelX, yelY) < 30 ) {
    tmp=yelDX;  yelDX=bluDX;  bluDX=tmp;
    tmp=yelDY;  yelDY=bluDY;  bluDY=tmp;
  }
  if (cueDX != 0){ 
  if ( dist( bluX,bluY, cueX, cueY) < 30 ) {
    tmp=cueDX;  cueDX=bluDX;  bluDX=tmp;
    tmp=cueDY;  cueDY=bluDY;  bluDY=tmp;
  }
  if ( dist( cueX, cueY, redX,redY) < 30 ) {
    tmp=redDX;  redDX=cueDX;  cueDX=tmp;
    tmp=redDY;  redDY=cueDY;  cueDY=tmp;
  
}
 if( dist( cueX, cueY, yelX,yelY) < 30 ) {
    tmp=yelDX;  yelDX=cueDX;  cueDX=tmp;
    tmp=yelDY;  yelDY=cueDY;  cueDY=tmp;
} 
}
 fill(0);
 text(score, 500,40);  // Display score
 
 if( cueDX !=0) {
 if( dist( cueX, cueY, yelX,yelY) < 30 ) { //increase scor number
 score+= +1;  }
 if ( dist( cueX, cueY, redX,redY) < 30 ) {
   score+= +1;}
 if ( dist( bluX,bluY, cueX, cueY) < 30 ) {
   score+= +1;}
 }
 if ( dist( bluX,bluY, yelX, yelY) < 30 ) {
   score+= +1;}
 if ( dist( redX,redY, bluX,bluY)  < 30 ) {
   score+= +1;}
 if ( dist( redX,redY, yelX,yelY ) < 30 ) {
   score+= +1;}
   
 }

//// SHOW:  balls, messages
void show() {
  fill( 255,255,255 );    ellipse( redX,redY, 30,30 );
  fill( 255,0,0 );    ellipse( redX,redY, 30,30 );
  fill( 255,255,0 );  ellipse( yelX,yelY, 30,30 );
  fill( 0,0,255 );    ellipse( bluX,bluY, 30,30 );
  fill( 255,255,255 );    ellipse( cueX,cueY, 30,30 );
}
void messages() {
  fill(0);
  text( title, width/3, 20 );
  text( news, width/3, 40 );
  text( author, 10, height-10 );
}

//// HANDLERS:  keys, click
void keyPressed() {
  if (key == 'r') {
    reset();
  }
  if (key == 'l'){
    cueDX=random(-2,2);
    cueDY=random(-2,2);
  }
  if (key == 'L'){
    cueDX=random(-2,2);
    cueDY=random(-2,2);
  }
}
