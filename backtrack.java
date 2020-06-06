/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myalgo;

import java.util.Scanner;

public class backtrack {
    public int[][] Graph ;
    public int[] color ;
    public int V ,ColorNum ;
   
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        backtrack gr = new backtrack() ;
        
        System.out.println("Enter number of verticesz");
        int V = scan.nextInt();

        System.out.println("Enter matrix");
         int graph[][] = new int[V][V];
 
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                graph[i][j] = scan.nextInt();
        // Check if it undirected graph or not
        for(int i=0;i<V;i++)
        {   for(int j=0;j<V;j++)
            {
                int x =graph[i][j] , y =graph[j][i] ;
                if(x!=y)
                {
                    System.out.println("The graph is not undirected graph");
                    System.exit(0);
                }
            }
        }
        System.out.println("Enter number of colors");
        int c = scan.nextInt();
       
        
        if(gr.graphcolor(graph, c)==true )
        {
            for(int i =0 ;i<V;i++) System.out.println(gr.color[i]);
            
        }
        else System.out.println("That number of colors can't color the graph");
    }
    // backtrack solution
    public boolean graphcolor(int[][]graph ,int Colors_Number)
    {
        V = graph.length ;
        ColorNum = Colors_Number ;
        color = new int[V] ;
        Graph = graph ; 
        
       
        try
        {
            GetSolve(0);
            System.out.println("No solution");
            return false ;
        }

        catch (Exception e)
        {
            System.out.println("Solution exists ");
           return true ;

        }
    }

 

public boolean GetSolve(int v) throws Exception
{
        if (v == V)
            throw new Exception("Solution found");
    
        for (int counter = 1; counter <= ColorNum; counter++)
        {
            if (isSafe(v, counter))
            {

                color[v] = counter;
                GetSolve(v + 1);
               color[v] = 0 ;
            }
           

        }
    return true ;
}

public boolean isSafe(int v, int counter)

    {

        for (int i = 0; i < V; i++)
        {
            if (Graph[v][i] == 1 && counter == color[i])
                return false;
        }
        return true;

    }

}