package dio.projects;

public class Client {

    private String name;
    private String CPF;
    private String pixNumber;

    public Client(String name, String CPF, String pixNumber) {
        this.name = name;
        this.CPF = CPF;
        this.pixNumber = pixNumber;
    }

    public String getName() {
        return name;
    }

    public String getCPF() {
        return CPF;
    }

    public String getPixNumber() {
        return pixNumber;
    }
}
