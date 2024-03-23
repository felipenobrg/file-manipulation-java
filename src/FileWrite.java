import java.io.*;
import java.util.Scanner;

public class FileWrite {
    private String fileName;

    public FileWrite(String fileName) {
        this.fileName = fileName;
    }

    public void writeFile(String data) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(data + "\n");
            writer.close();
            System.out.println("Nome adicionado ao arquivo com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro na escrita do arquivo: " + e);
        }
    }

    public void readFile() {
        try {
            FileReader input = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(input);
            String line;
            System.out.println("Nomes nos arquivos:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
            input.close();
        } catch (IOException e) {
            System.out.println("Erro na leitura do arquivo: " + e.getMessage());
        }
    }

    public void deleteFile() {
        File file = new File(fileName);
        if (file.delete()) {
            System.out.println("Arquivo deletado com sucesso.");
        } else {
            System.out.println("Erro ao deletar o arquivo.");
        }
    }

    public static void main(String[] args) {
        FileWrite fileWriter = new FileWrite("names.txt");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Escrever nome em arquivo");
            System.out.println("2. Mostrar todos os nomes dos arquivos");
            System.out.println("3. Deletar todos os arquivos");
            System.out.println("4. Sair");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Digite o nome a ser adicionado:");
                    String name = scanner.nextLine();
                    fileWriter.writeFile(name);
                    break;
                case 2:
                    fileWriter.readFile();
                    break;
                case 3:
                    fileWriter.deleteFile();
                    break;
                case 4:
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
