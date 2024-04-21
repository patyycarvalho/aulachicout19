package br.com;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscreverCSV {
    public static void main(String[] args) {
        String arquivoCSV = "funcionarios.csv";

        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(arquivoCSV))) {
            try (Scanner scanner = new Scanner(System.in)) {
                // Solicitar informações dos funcionários ao usuário
                System.out.println("Adicionar novo funcionário:");
                System.out.print("Nome: ");
                String nome = scanner.nextLine();

                System.out.print("Cargo: ");
                String cargo = scanner.nextLine();

                System.out.print("Salário: ");
                double salario = Double.parseDouble(scanner.nextLine());

                // Escrever as informações do funcionário no arquivo CSV
                String[] linha = {nome, cargo, String.valueOf(salario)};
                csvWriter.writeNext(linha);
            } catch (NumberFormatException e) {
       
                e.printStackTrace();
            }

            System.out.println("Funcionário adicionado com sucesso ao arquivo CSV!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

