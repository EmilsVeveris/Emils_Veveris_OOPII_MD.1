package model;

import utils.DataVerification;

public class Person {
	private String name;
	private String surname;
	private String idenNr;
	private IdenType identity;
	private Nationality nationality; 
	
	public String getIdenNr() {
		return idenNr;
	}

	public void setIdenNr(String idenNr) {
		
		this.idenNr = (idenNr != null) ? DataVerification.idenNrVerificaton(idenNr) : "";

	}
	
	public Nationality getNationality() {
		return nationality;
	}

	public void setNationality(Nationality nationality) {
		if (nationality != null)
			this.nationality = (nationality != null) ? nationality : Nationality.LATVIAN;

	}

	public void setIdenType(IdenType identity) {
		if (identity != null)
			this.identity = (identity != null) ? identity : IdenType.IDCARD;

	}
	public IdenType getIdenType() {
		return identity;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public void setName(String name) {
		this.name = (name != null) ? DataVerification.nameAndSurnameVerificaton(name) : "";
	}

	public void setSurname(String surname) {
		this.surname = (surname != null) ? DataVerification.nameAndSurnameVerificaton(surname) : "";
	}
	

	public Person()
	{
		name = "";
		surname = "";
		nationality = Nationality.LATVIAN;
		identity = IdenType.PASSPORT;
		idenNr = "";
				
	}
	public Person(String name, String surname, Nationality nationality, IdenType idenType, String idenNr)
	{
		setName(name);
		setSurname(surname);
		setNationality(nationality);
		setIdenType(idenType);
		setIdenNr(idenNr);
	}
	
	public String toString()
	{
		return name + " " + surname + " : " + nationality + " : " + identity + ", " + idenNr;
	}
}

