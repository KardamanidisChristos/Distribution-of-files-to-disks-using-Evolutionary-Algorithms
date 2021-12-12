/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filetodiscs;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author user
 */
public class FileToDiskSolver {
      Population population = new Population();
    Individual fittest;
    Individual secondFittest;
    int generationCount = 0;//number of generation happened
    
     void selection() {

        //Select the most fittest individual
        fittest = population.getFittest();

        //Select the second most fittest individual
        secondFittest = population.getSecondFittest();
        //DEFAULT WORKING,CHECKED
    }
     void selection1(){
         System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
      population.printPopulation();
         System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        int rn1=0;
     boolean[] mphke=new boolean[population.size];    
     int rn=(int)(Math.random()*(population.size-2));//to megethos tou pinaka tou 2ou stage
     Individual[] ind=new Individual[rn];
     //gia kathe thesi tou pinaka tou 2ou stage
     for(int i=0; i<ind.length; i++){
        //epilegw enan tixaio deikti gia na parw tin antistixi timi apo ton pinaka tou stage
         do{
         
                   rn1=(int)(Math.random()*population.size);//timi gua tin opoia pairnw antikeimena apo to 1o stage

         
         
         }while(mphke[rn1]);
         
         System.out.println("rn1 "+rn1);
         ind[i]=population.individuals[rn1];
        
         mphke[rn1]=true;
         
        
         

     
     
     }
      //exoume etoimo ton pinaka me ta indivi tou stage2 
         Arrays.sort(ind);
         System.out.println("1================>"+ind[0]);
         System.out.println("2================>"+ind[1]);
         //Individual f1=ind[0];
         //Individual f2=ind[1];
         //fittest=f1;
         //secondFittest=f2;
     
     }
     
     void crossover() {
        Random rn = new Random();

        //Select a random crossover point
        int crossOverPoint = rn.nextInt(population.individuals[0].disc_dis.length);

        //Swap values among parents
        for (int i = 0; i < crossOverPoint; i++) {
            int temp = fittest.disc_dis[i];
            fittest.disc_dis[i] = secondFittest.disc_dis[i];
            secondFittest.disc_dis[i] = temp;

        }
    //implicit elimination of weekest
    //default,working
    }
     void crossover1(){
      //XIASTI TWN 2 PROTWN
        int index=new Random().nextInt(population.individuals[0].disc_dis.length);
        Individual ob1=fittest;
        Individual ob2=secondFittest;
        for(int i=0;i<population.individuals[0].disc_dis.length;i++){
        if(i>index){
        int tmp1 =ob1.disc_dis[i];
        int tmp2 =ob2.disc_dis[i];
        
        ob1.disc_dis[i]=tmp2;
        ob2.disc_dis[i]=tmp1;
        //NEEDS TO BE CHECKED
        }
        
        
        
        }
     }
     
     void mutation() {
        Random rn = new Random();

        //Select a random mutation point
        int mutationPoint = rn.nextInt(population.individuals[0].disc_dis.length);

        //Flip values at the mutation point
        if (fittest.disc_dis[mutationPoint] == 0) {
            fittest.disc_dis[mutationPoint] = 1;
        } else {
            fittest.disc_dis[mutationPoint] = 0;
        }

        mutationPoint = rn.nextInt(population.individuals[0].disc_dis.length);

        if (secondFittest.disc_dis[mutationPoint] == 0) {
            secondFittest.disc_dis[mutationPoint] = 2;
        } else {
            secondFittest.disc_dis[mutationPoint] = 3;
        }
        //DEFAULT,CHECKED
    }
     void mutation1(){
         //generate 2 random indexes in order to access dna of each individual of population
        int r1=(int)(Math.random()*population.individuals[0].disc_dis.length);
        int r2=(int)(Math.random()*population.individuals[0].disc_dis.length);
        if(r1==r2){
            r2=(int)(Math.random()*population.individuals[0].disc_dis.length);
        }else{
        
            for(int i=0;i<population.individuals.length;i++){
                
                int n1=population.individuals[i].disc_dis[r1];
                int n2=population.individuals[i].disc_dis[r2];
                population.individuals[i].disc_dis[r1]=n2;
                population.individuals[i].disc_dis[r2]=n1;
        
        }
        //Individual temp=population.individuals[r1];
        //population.individuals[r1]=population.individuals[r2];
        //population.individuals[r2]=temp;
         }
     
     //CHECKED
     }
     
     Individual getFittestOffspring() {
        if (fittest.fitness > secondFittest.fitness) {
            return fittest;
        }
        return secondFittest;
    }
     void addFittestOffspring() {

        //Update fitness values of offspring
        fittest.calcFitness();
        secondFittest.calcFitness();

        //Get index of least fit individual
        int leastFittestIndex = population.getLeastFittestIndex();

        //Replace least fittest individual from most fittest offspring
        population.individuals[leastFittestIndex] = getFittestOffspring();
    }
}
