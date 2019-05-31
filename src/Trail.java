import java.util.*;
import java.awt.*;
import javax.swing.JPanel;

public class Trail {
  public float x;
  public float y;
  public float heigt;
  public float length;
  public float startX;
  public float startY;
  
  public Trail() {
    this.x = -1000;
    this.y = -1000;
    this.height = 0;
    this.length = 0;
  }
  
  public Trail (float x, float y, float height, float length) {
    this.x = x;
    this.y = y;
    this.height = height;
    this.length = length;
  }
  
  public void startTrailFloor(){
    this.startX = this.x;
    this.height = 10;
  }
  
  public void endTrailFloor(){
    if (this.length < Math.abs(this.x - this.startX) ){
      this.length = Math.abs(this.x - this.startX);
      this.height = 10;
    }
  }
  
  public void startTrailWall(){
    this.startY = this.y;
    this.length = 10;
  }
  
  public void endTrailWall(){
    if (this.height < Math.abs(this.y - this.startY) ){
      this.height = Math.abs(this.y - this.startY);
      this.length = 10;
    }
  }
  
}
