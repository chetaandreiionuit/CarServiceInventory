package ShopAndService.Utilities;

public class Piesa{
    int idPiesa;
    String numePiesa;
    String numeFurnizor;
    int stocPiesa;
    int costPiesa;

    public Piesa(int idPiesa, String numePiesa, String numeFurnizor, int stocPiesa, int costPiesa) {
        this.idPiesa = idPiesa;
        this.numePiesa = numePiesa;
        this.numeFurnizor = numeFurnizor;
        this.stocPiesa = stocPiesa;
        this.costPiesa = costPiesa;
    }

//-------------------------------------------------------------------------------------------

    public int getIdPiesa() {
        return idPiesa;
    }

    public void setIdPiesa(int idPiesa) {
        this.idPiesa = idPiesa;
    }

    public String getNumePiesa() {
        return numePiesa;
    }

    public void setNumePiesa(String numePiesa) {
        this.numePiesa = numePiesa;
    }

    public String getNumeFurnizor() {
        return numeFurnizor;
    }

    public void setNumeFurnizor(String numeFurnizor) {
        this.numeFurnizor = numeFurnizor;
    }

    public int getStocPiesa() {
        return stocPiesa;
    }

    public void setStocPiesa(int stocPiesa) {
        this.stocPiesa = stocPiesa;
    }

    public int getCostPiesa() {
        return costPiesa;
    }

    public void setCostPiesa(int costPiesa) {
        this.costPiesa = costPiesa;
    }

//---------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Piesa{" +
                "idPiesa=" + idPiesa +
                ", numePiesa='" + numePiesa + '\'' +
                ", numeFurnizor='" + numeFurnizor + '\'' +
                ", stocPiesa=" + stocPiesa +
                ", costPiesa=" + costPiesa +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piesa piesa = (Piesa) o;
        return numePiesa.equals(piesa.numePiesa);

    }

}
