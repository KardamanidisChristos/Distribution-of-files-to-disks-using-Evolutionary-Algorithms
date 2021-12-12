package filetodiscs;

class Population {

    int size = 16;//Population size
    Individual[] individuals = new Individual[30];//Array of solutions in a generation
    double fittest = 0;//fitness of the best solution

    //Initialize population
    public void initializePopulation(int size) {
        for (int i = 0; i < size; i++) {
            individuals[i] = new Individual();
        }
        this.size=size;
    }

    //Get the fittest individual-solution
    public Individual getFittest() {
        double maxFit = Integer.MIN_VALUE;
        int maxFitIndex = 0;
        for (int i = 0; i < size; i++) {
            if (maxFit <= individuals[i].fitness) {
                maxFit = individuals[i].fitness;
                maxFitIndex = i;
            }
        }
        fittest = individuals[maxFitIndex].fitness;
        return individuals[maxFitIndex];
    }

    //Get the second most fittest individual
    public Individual getSecondFittest() {
        int maxFit1 = 0;
        int maxFit2 = 0;
        for (int i = 0; i < size; i++) {
            if (individuals[i].fitness > individuals[maxFit1].fitness) {
                maxFit2 = maxFit1;
                maxFit1 = i;
            } else if (individuals[i].fitness > individuals[maxFit2].fitness) {
                maxFit2 = i;
            }
        }
        return individuals[maxFit2];
    }

    //Get index of least fittest individual
    public int getLeastFittestIndex() {
        double minFitVal = Integer.MAX_VALUE;
        int minFitIndex = 0;
        for (int i = 0; i < size; i++) {
            if (minFitVal >= individuals[i].fitness) {
                minFitVal = individuals[i].fitness;
                minFitIndex = i;
            }
        }
        return minFitIndex;
    }

    //Calculate fitness of each individual
    public void calculateFitness() {

        for (int i = 0; i < size; i++) {
            individuals[i].calcFitness();
        }
        getFittest();
    }
    public void printPopulation(){
    for (int i=0; i<size;i++){
        System.out.println("Solution"+i);
    individuals[i].printGenes();
    
        System.out.println("FIT==>"+individuals[i].fitness);
    
    //System.out.println("Fitness of this DNA "+individuals[i].fitness);
    }
    
    
    }

}