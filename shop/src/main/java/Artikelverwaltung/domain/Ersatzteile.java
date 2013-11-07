package Artikelverwaltung.domain;

public class Ersatzteile extends AbstractArtikel {
	private Fahrrad fahrrad;

	public Fahrrad getFahrrad() {
		return fahrrad;
	}

	public void setFahrrad(Fahrrad fahrrad) {
		this.fahrrad = fahrrad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((fahrrad == null) ? 0 : fahrrad.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ersatzteile other = (Ersatzteile) obj;
		if (fahrrad == null) {
			if (other.fahrrad != null)
				return false;
		} else if (!fahrrad.equals(other.fahrrad))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ersatzteile [fahrrad=" + fahrrad + "]";
	}

}
