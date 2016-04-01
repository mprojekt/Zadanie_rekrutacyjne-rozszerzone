package m.mprojekt;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.StringTokenizer;
import java.util.stream.Stream;
import m.mprojekt.transaction.*;


public class DecodingTxtFile {

    public static void main(String[] args) {
        String filePath = "Plik z danymi.txt";
        if(args.length != 0) {
            filePath = args[0];
        }
        
        Path path = Paths.get(filePath);
        Transactions transactions = new Transactions();
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(Files.newInputStream(path), StandardCharsets.UTF_8))) {
            
            Stream<String> lines = br.lines();
            lines.filter(s -> s.length() > 0)
                    .map(s -> createTransactionFromString(s))
                    .forEach(t -> transactions.add(t));
            
        } catch (Exception ex) {
            System.out.println("Nieprawidłowy plik.\n" + ex);
        } 
        
        transactions.printStatistic();
    } 
    
    private static Transaction createTransactionFromString(String line){
        StringTokenizer st = new StringTokenizer(line, "@");        
        
        String token = st.nextToken();
        String name = token.substring(token.indexOf(":") + 1);
        token = st.nextToken();
        String surename = token.substring(token.indexOf(":") + 1);
        token = st.nextToken();
        String sourceIban = token.substring(token.indexOf(":") + 1);
        token = st.nextToken();
        String destinationIban = token.substring(token.indexOf(":") + 1);
        token = st.nextToken();
        double amount = Double.parseDouble(token.substring(token.indexOf(":") + 1, token.length() - 3).replaceAll(",", "."));
        
        return new Transaction(name, surename, sourceIban, destinationIban, amount);
    }
}