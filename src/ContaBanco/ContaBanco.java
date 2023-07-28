package ContaBanco;

public class ContaBanco {
    public int numConta;
    protected String tipoConta;
    private String titular;
    private double saldo;
    private boolean status;

    public ContaBanco() {
        saldo = 0;
        status = false;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        if(numConta <= 0) {
            throw new RuntimeException("Número de conta inválido");
        }
        else {
            this.numConta = numConta;
        }
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        if(!tipoConta.equals("cp") && !tipoConta.equals("cc")) {
            throw new RuntimeException("Tipo de conta inválida! Digite cc para conta corrente e cp para conta poupança. ");
        }
        else {
            this.tipoConta = tipoConta;
        }
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void abrirConta(String tipo) {
        setTipoConta(tipo);
        setStatus(true);

        if(tipo.equals("cp")) {
            setSaldo(getSaldo() + 150);
        }
        else {
            setSaldo(getSaldo() + 50);
        }
        System.out.println("Conta aberta com sucesso. ");
    }
    public void fecharConta() {
        if(saldo > 0) {
            System.out.println("Não é possível fechar a conta, pois a conta contém saldo. ");
        }
        else {
            setStatus(false);
            System.out.println("Conta fechada com sucesso. ");
        }
    }

    public void depositar(double valorDeposito) {
        if(status && valorDeposito > 0) {
            setSaldo(getSaldo() + valorDeposito);
            System.out.println("Valor depositado com sucesso! ");
        }
        else {
            System.out.println("Não foi possível efetuar o depósito! ");
        }
    }

    public void sacar(double valorSaque) {
        if(status && valorSaque <= saldo && valorSaque > 0) {
            setSaldo(getSaldo() - valorSaque);
            System.out.println("Saque depositado com sucesso! ");
        }
        else {
            System.out.println("Não foi possível efetuar o saque! ");
        }
    }

    public void pagarMensalidade() {
            if (saldo <= 0) {
                System.out.println("Sem saldo! ");
            } else if (tipoConta.equals("cc") && saldo >= 12) {
                setSaldo(getSaldo() - 12);
                System.out.println("Mensalidade de 12 reais! ");
            } else if (tipoConta.equals("cp") && saldo >= 20) {
                setSaldo(getSaldo() - 20);
                System.out.println("Mensalidade de 20 reias");
            } else {
                System.out.println("Não há saldo suficiente! ");
            }
    }
}
