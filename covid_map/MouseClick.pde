
boolean mouseClicked = false;
boolean used = false;

boolean isMouseClicked(){
  return mouseClicked && !used;
}

void useMouseClick(){
  used = true; 
}

void mousePressed(){
  if(used == false)
    mouseClicked = true;
}

void mouseReleased() {
  mouseClicked = false;
  used = false;
}
