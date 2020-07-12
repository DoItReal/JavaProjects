/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doitreal.mazesolver;

import java.util.LinkedList;



public class MazeSolver {
  static int[][] maze = {
{0,0,1,3},
{1,1,0,1},
{2,1,0,1},
{0,1,1,1},
};
static LinkedList <Position> path = new LinkedList<>();
//0 - wall
//1 - path
//2 - destination  
//3 - start

    /**
     *
     * @param maze
     * @return
     */
public static Position FindStart(int[][] maze){
    for(int i=0;i<maze.length;i++){
        for(int j=0;j<maze[i].length;j++){
            if(maze[i][j] == 3) return new Position(i,j);
        }
    }
    return new Position(0,1);
}

private static Position FindNext(Position pos){
   LinkedList <Position> localPath = new LinkedList<>(); 
    if(pos.x != 0){
        switch(maze[pos.y][pos.x-1]){                   // go left x-1
            case 0: break;
            case 1: localPath.push(new Position(pos.y, pos.x-1)); break;
            case 2: return new Position(pos.y, pos.x-1);
            case 3: break;
        }
    }
    if(pos.y < maze.length-1 && maze[pos.y+1].length-1>=pos.x){
        switch(maze[pos.y+1][pos.x]){                   // go down y+1
            case 0: break;
            case 1: localPath.push(new Position(pos.y+1, pos.x)); break;
            case 2: return new Position(pos.y+1, pos.x);
            case 3: break;
        }
    }
    if(pos.x < maze[pos.y].length-1){
        switch(maze[pos.y][pos.x+1]){                   // go right x+1
            case 0: break;
            case 1: localPath.push(new Position(pos.y,pos.x+1)); break;
            case 2: return new Position(pos.y, pos.x+1);
            case 3: break;
        }
    }
    if(pos.y != 0 && maze[pos.y-1].length-1 >= pos.x){
        switch(maze[pos.y-1][pos.x]){                   // go up y-1
            case 0: break;
            case 1: localPath.push(new Position(pos.y-1, pos.x)); break;
            case 2: return new Position(pos.y-1, pos.x);
            case 3: break;
        }
    }
    if(localPath.isEmpty())return pos;
    else return localPath.getFirst();
}

public static void main(String[] args) {
     path.add(FindStart(maze));
    
     
    while(maze[path.getLast().y][path.getLast().x] != 2){
         Position newPos = FindNext(path.getLast());
         if (newPos.y == path.getLast().y && newPos.x == path.getLast().x){
             maze[path.getLast().y][path.getLast().x] = 0;
             path.removeLast();  
             maze[path.getLast().y][path.getLast().x] = 1;
         }else {
             maze[path.getLast().y][path.getLast().x] = 0;
             path.add(newPos);
         }
         if (maze[path.getLast().y][path.getLast().x]== 2) break;
     } 
     if (maze[path.getLast().y][path.getLast().x] == 2){
     System.out.println("Found the destination at: y: " + path.getLast().y + " x: " + path.getLast().x);
    }else{
         System.out.println("Failed");
     }


}
}
