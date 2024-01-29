package assignment2;
class Matrix{
    int[][] array;
    int r,c;
    public Matrix(int[] array, int r, int c){
        this.c = c;
        this.r = r;
        this.array=new int[r][c];
    }
    public void multiply(int[][] arr, int mult, int c, int r){
        for(int i=0;i<r;i++){
            for(int j=0; j<c;j++){
                arr[i][j] *= mult;
                System.out.println(arr[i][j]);
            }
        }
    }
    public void printMatrix(int[][] arr, int c, int r) {
        for(int i=0;i<r;i++){
            for(int j=0; j<c;j++){
                System.out.println(arr[i][j]);
            }
        }
    }
    public void sum(int[][] arr, int[][] arr2, int c, int r){
        for(int i =0; i<r; i++){
            for(int j=0;j<c; j++){
                arr[i][j]+=arr2[i][j];
            }
        }
    }
}
