package Modele;



import java.util.Random;

    /**
     * \class PontBrownien
     * \brief Simulate a Brownian Movement for assets value
     */
    public class PontBrownien{
        private static int nombreTour;
        private  static double s0; /**<Values of  asset */

        public PontBrownien(int nombreTour,double s0){
            this.nombreTour = nombreTour;
            this.s0 = s0;
        }

        private  double normal(double m, double sigma){
            Random rand = new Random();
            double nCentreReduite = rand.nextGaussian();
            return  m + Math.sqrt(sigma)*nCentreReduite;
        }

        /**
         * \fn double[] simuler(int nbrAction)
         * \brief calculer mouvement brownien des cours
         *
         * \return double[][] :  list of prices of assets in all rounds
         */
        public double[] simuler() {
            double[] cours = new double[nombreTour];
            //on simule W0 trivial c'est initial et WT avec loi normal (0,T)
            cours[0] = s0;
            cours[nombreTour - 1] = s0 + normal(0, nombreTour);
            dicotomie(0, nombreTour - 1, cours);
            return cours;
        }

        /**
         * \fn double[][] dicotomie()
         * \brief Appliquer pont brownien brownien
         *
         * \return double[][] :  list of prices of assets in all rounds
         */
        public void dicotomie(int ia,int ib,double[] cours){
            //Condition d'arret
            if(ib-ia>1) {
                //calcul de milieu
                int im = (ib + ia) / 2;
                double mean  = cours[ia] + ((double) (im -  ia)) / ((double) (ib - ia)) * (cours[ib] - cours[ia]);
                double sigma =  ((double) (im -  ia)) / ((double) (ib - ia)) * ((double) (ib - im));
                cours[im] = normal(mean, sigma);
                // dicotomie à gauche
                dicotomie(ia, im, cours);
                // dicotomie à droite
                dicotomie(im, ib, cours);
            }


        }


    }
