import java.util.ArrayList;
import java.util.List;

public class TarjertaDeCredito {
    private double limite;
    private double saldo;
    private List<Compra> lanzarCompra;

    public TarjertaDeCredito(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.lanzarCompra = new ArrayList<>();
    }


    public boolean LanzarCompra(Compra compra){
        if ( this.saldo >= compra.getPrecio()){
            this.saldo -= compra.getPrecio();
            this.lanzarCompra.add(compra);
            return true;
        }
        return false;
    }

    public double getLimite() {
        return limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Compra> getLanzarCompra() {
        return lanzarCompra;
    }
}
