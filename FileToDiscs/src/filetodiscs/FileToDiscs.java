/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filetodiscs;
//22.5.2018 final edition
import java.util.Random;

/**
 *
 * @author user
 */
public class FileToDiscs {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
    executeAlgorithm();
    }
    public static void executeAlgorithm(){
        Random rn = new Random();
        double max=-2;
        int[] best=new int[13];
        int first_best_gen=0;
        FileToDiskSolver demo = new FileToDiskSolver();
        double fitt=0;
        //Initialize population
        demo.population.initializePopulation(4);

        //Calculate fitness of each individual
        demo.population.calculateFitness();
        demo.population.printPopulation();
        System.out.println("Generation: " + demo.generationCount + " Fittest: " + demo.population.fittest);

        
        
        //While population gets an individual with maximum fitness
        while ( demo.generationCount<200) {
            System.out.println("====================================================");

            
            ++demo.generationCount;

            //Do selection
            demo.selection();

            //Do crossover
            demo.crossover();

            //Do mutation under a random probability
            if (rn.nextInt()%7 < 5) {
                demo.mutation();
            }

            //Add fittest offspring to population
            demo.addFittestOffspring();

            //Calculate new fitness value
            demo.population.calculateFitness();
            //demo.population.printPopulation();
            System.out.println("Generation: " + demo.generationCount + " Fittest: " + demo.population.fittest);
            System.out.println("Dna of best individual!");
            demo.population.getFittest().printGenes();
            if(demo.population.fittest>max){
                max=demo.population.fittest;
                 best=demo.population.getFittest().disc_dis.clone();
               
                first_best_gen=demo.generationCount;
            }
            System.out.println("Fittest of all generations till now"+max+" generation=>"+first_best_gen);
            
           //Thread.sleep(10000);
            System.out.println("====================================================");
        }

        
        
        
        
        
        
        
       // System.out.println("\nSolution found in generation " + demo.generationCount);
       // System.out.println("Fitness: "+demo.population.getFittest().fitness);
        //if(demo.population.getFittest().fitness>fitt){fitt=demo.population.getFittest().fitness;}
        System.out.println("*******************FINAL RESULTS***********************");
        System.out.println("Maximum fitness found"+max);
        System.out.println("Generation first found "+first_best_gen);
        System.out.print("Genes: \n");
         for (int i = 0; i < 13; i++) {
            System.out.print("--File"+i+"--");
        }
        System.out.println("");
        for (int i = 0; i < 13; i++) {
            System.out.print("----"+best[i]+"---");
        }

        System.out.println("");
    System.gc();
    }
}
