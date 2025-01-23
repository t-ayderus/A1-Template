package ca.mcmaster.se2aa4.mazerunner;


//Class to model a Compass
public class Compass{


    private char D = 'E';

    public char getDirection()
    {
        return this.D;
    }

    //Change Direction Left
    public void left()
    {
        switch(this.D){
            case 'N':
                this.D='W';
            break;
            case 'E':
                this.D='N';
            break;
            case 'S':
                this.D='E';
            break;
            case 'W':
                this.D='S';
            break;
        }
    }

    //Change Direction Right
     public void right()
    {
        switch(this.D){

            case 'N':
                this.D='E';
            break;
            case 'E':
                this.D='S';
            break;
            case 'S':
                this.D='W';
            break;
            case 'W':
                this.D='N';
            break;
        }
    }
}