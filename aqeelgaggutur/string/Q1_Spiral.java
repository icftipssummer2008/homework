class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0) return res;
        if(matrix[0].length == 0) return res;
        boolean forward = true;
        boolean down = false;
        boolean back = false;
        boolean up = false;
        long count = matrix.length * matrix[0].length;
        int c = 1;
        int i =0;
        int j =0;
        while(c <= count){
            if(matrix[i][j] != Integer.MIN_VALUE){
                res.add(matrix[i][j]);
                matrix[i][j] = Integer.MIN_VALUE;
                if(forward && !down && !up && !back){
                    if(j + 1 < matrix[i].length && matrix[i][j+1] != Integer.MIN_VALUE){
                        j++;
                    } else {
                        forward = false;
                        down = true;
                        i++;
                    }
                } else if(down && !forward && !up && !back){
                    if(i + 1 < matrix.length && matrix[i+1][j] != Integer.MIN_VALUE){
                        i++;
                    } else {
                        back = true;
                        down = false;
                        j--;
                    }
                } else if(back && !forward && !up && !down){
                    if(j - 1 >= 0 && matrix[i][j - 1] != Integer.MIN_VALUE){
                        j--;
                    } else{
                        back = false;
                        up = true;
                        i--;
                    }
                } else {
                    if(i - 1 >= 0 && matrix[i-1][j] != Integer.MIN_VALUE){
                        i--;
                    } else {
                        up = false;
                        forward = true;
                        j++;
                    }
                }
                c++;
            }
        }
        return res;
    }
}