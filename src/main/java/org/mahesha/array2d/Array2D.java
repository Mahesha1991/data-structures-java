package org.mahesha.array2d;

public class Array2D {

    public static void main(String[] args) {
        int [][] matrix = new int[3][4];

        

        //Example
        //[   [62 40 42 85]
        //    [27 95 17 45]
        //    [78 82 31 18 ]  ]


        for(int i = 0; i < 3; i++){

            for(int j = 0; j < 4; j++){
                matrix[i][j] = (int) (Math.random() * 100);
            }
        }

        for(int i = 0; i < 3; i++){

            for(int j = 0; j < 4; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        //Enhanced For Loop
        for(int [] rows: matrix){

            for(int column : rows){
                System.out.print(column + " ");
            }
            System.out.println();
        }


        //Jagged Array where length of each row would not be equal

        int [][] jaggedMatrix = new int[3][];

        System.out.println("Jagged Matrix: ");

        for(int i = 0; i < 3; i++){

            int len = (int) (Math.random() * 10);
            //Jagged Matrix where each row size would be different
            jaggedMatrix[i] = new int[len];

            for(int j = 0; j < len; j++){
                jaggedMatrix[i][j] = (int) (Math.random() * 100);
            }
        }


        for(int [] rows: jaggedMatrix){

            for(int column : rows){
                System.out.print(column + " ");
            }
            System.out.println();
        }

    }
}
