package guanabara;

public class ContaBanco {
    public int numConta;
    protected String tipo;
    private String dono;
    private double saldo;
    private boolean status;


    public ContaBanco(int numConta, String tipo, String dono, String saldo, boolean status) {
        this.numConta = numConta;
        this.tipo = tipo;
        this.dono = dono;
        this.saldo = 0;
        this.status = false;
    }

    public void estadoConta() {
        System.out.println("Conta: " + this.getNumConta());
        System.out.println();
        System.out.println();
    }

    public void abrirConta(String tipo) {
        this.setTipo(tipo);
        this.setStatus(true);
        if (tipo == "cc") {
            this.setSaldo(100);
        } else if (tipo == "cp") {
            this.setSaldo(200);
        }
        System.out.println("Conta aberta com sucesso!");
    }

    public void fecharConta() {
        if (this.getSaldo() > 0) {
            System.out.println("Favor sacar todo dinheiro!");
        } else if (this.getSaldo() < 0) {
            System.out.println("Favor liquidar o débito");
        } else {
            setStatus(false);
            System.out.println("Conta fechada com sucesso!");
        }
    }

    public void depositar(double valor) {
        if (this.getStatus()) {
            this.setSaldo(getSaldo() + valor);
            System.out.println("Deposito realizado na conta " + getDono());
        } else {
            System.out.println("Conta inexistente!");
        }
    }

    public void sacar(double valor) {
        if (this.getStatus()) {
            if (this.getSaldo() >= valor) {
                this.setSaldo(this.getSaldo() - valor);
                System.out.println("Saque realizado com sucesso! " + getDono());
            } else {
                System.out.println("Saldo insuficiente para saque!");
            }
        } else {
            System.out.println("Conta inexistente!");
        }
    }

    public void pagarMensalidade() {

        double mensal = 0;
        if (this.getTipo() == "cc") {
            mensal = 20.0;
        } else if (this.getTipo() == "cp") {
            mensal = 30.0;
        } else if (this.getStatus()) {
            this.setSaldo(this.getSaldo() - mensal);
            System.out.println("Mensalidade debitada com sucesso! " + getDono());
        }
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
