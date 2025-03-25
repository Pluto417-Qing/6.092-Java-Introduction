import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MagicSquares {
    public static boolean testMagic(String pathName) throws IOException {
        String line;
        ArrayList<ArrayList<Integer>> lines = new ArrayList<>();

        try (FileReader fileReader = new FileReader(pathName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while ((line = bufferedReader.readLine()) != null) {
                if(line.isEmpty())continue;

                String[] numbs = line.split("\t");
                ArrayList<Integer> temp = new ArrayList<>();
                for (String num : numbs) {
                    temp.add(Integer.parseInt(num));
                }
                lines.add(temp);
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("文件不存在: " + pathName);
        } catch (NumberFormatException e) {
            throw new IOException("文件内容格式错误: " + pathName);
        }

        return checkColumns(lines) && checkDiagonal(lines) && checkRows(lines);
    }

    public static void main(String[] args) throws IOException {
        String[] fileNames = { "Mercury.txt", "Luna.txt" };
        for (String fileName : fileNames) {
            System.out.println(fileName + " is magic? " + testMagic(fileName));
        }
    }

    public static boolean checkColumns(ArrayList<ArrayList<Integer>> lines){
        boolean isMagic = true;
        int sum = 0;
        int mid_sum;

        // 计算第一行的和作为基准
        for(ArrayList<Integer> row : lines){
            sum += row.getFirst();
        }

        for(int i = 0; i < lines.getFirst().size(); i++){
            mid_sum = 0;
            for(int j = 0; j < lines.size(); j++){
                mid_sum += lines.get(j).get(i);
            }
            if(sum == 0){
                sum = mid_sum;
            }
            if (mid_sum != sum) {
                isMagic = false;
                break;
            }
        }
        return isMagic;
    }

    public static boolean checkRows(ArrayList<ArrayList<Integer>> lines){
        boolean isMagic = true;
        int sum = 0;
        int mid_sum;

        // 计算第一行的和作为基准
        for(ArrayList<Integer> row : lines){
            sum += row.getFirst();
        }

        for(ArrayList<Integer> m : lines){
            mid_sum = 0;

            for (int n : m) {
                mid_sum += n;
            }

            if(sum == 0){
                sum = mid_sum;
            }
            if (mid_sum != sum) {
                isMagic = false;
                break;
            }
        }

        return isMagic;
    }

    public static boolean checkDiagonal(ArrayList<ArrayList<Integer>> lines){
        int sum1 = 0;
        int sum2 = 0;
        int size = lines.size();

        // 计算第一行的和作为基准
        int sum = 0;
        for(int n : lines.getFirst()) {
            sum += n;
        }

        for(int j = 0; j < size; j++){
            sum1 += lines.get(j).get(j);
        }

        for(int j = 0; j < size; j++){
            sum2 += lines.get(j).get(size - 1 - j);
        }
        return sum1 == sum2 && sum == sum1;
    }
}

