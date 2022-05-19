package payroll;

import java.util.Objects;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class PayDocs {

	private @Id @GeneratedValue Long id;
	private String DocNum;
	private Date date;

	public PayDocs() {
	}

	public void setNom_PP(Date nom_PP) {
		Nom_PP = nom_PP;
	}

	private Date Nom_PP;
	private Date Sum_PP;
	private Date Date_PP_IN;
	private Date Date_PP_OUT;
	private int Purpose_ID;
	private int Order_PAY;
	private int UIN;
	private String Purpose;
	private int Type_Pl;
	private Date Date_IN_TOFK;
	private String GUID;

	public void setDate(Date date) {
		this.date = date;
	}

	public void setSum_PP(Date sum_PP) {
		Sum_PP = sum_PP;
	}

	public Date getDate_PP_IN() {
		return Date_PP_IN;
	}

	public Date getDate_PP_OUT() {
		return Date_PP_OUT;
	}

	public int getPurpose_ID() {
		return Purpose_ID;
	}

	public void setPurpose_ID(int purpose_ID) {
		Purpose_ID = purpose_ID;
	}

	public int getOrder_PAY() {
		return Order_PAY;
	}

	public void setOrder_PAY(int order_PAY) {
		Order_PAY = order_PAY;
	}

	public int getUIN() {
		return UIN;
	}

	public void setUIN(int UIN) {
		this.UIN = UIN;
	}

	public String getPurpose() {
		return Purpose;
	}

	public void setPurpose(String purpose) {
		Purpose = purpose;
	}

	public int getType_Pl() {
		return Type_Pl;
	}

	public void setType_Pl(int type_Pl) {
		Type_Pl = type_Pl;
	}

	public Date getDate_IN_TOFK() {
		return Date_IN_TOFK;
	}

	public void setDate_IN_TOFK(Date date_IN_TOFK) {
		Date_IN_TOFK = date_IN_TOFK;
	}

	public String getGUID() {
		return GUID;
	}

	public void setGUID(String GUID) {
		this.GUID = GUID;
	}

	public PayDocs(String DocNum) {
		this.DocNum = DocNum;
	}

	public PayDocs(Long id) {
		this.id = id;
	}

	public Date getSum_PP() {
		return Sum_PP;
	}

	public Date getNom_PP() {
		return Nom_PP;
	}

	public Date getDate() {
		return date;
	}

	public Long getId() {
		return this.id;
	}

	public String getDocNum() {
		return this.DocNum;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDocNum(String DocNum) {
		this.DocNum = DocNum;
	}

	public void setDate_PP_IN(Date Date_PP_IN){
		this.Date_PP_IN = Date_PP_IN;
	}

	public void setDate_PP_OUT(Date Date_PP_OUT){
		this.Date_PP_OUT = Date_PP_OUT;
	}

	/*@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (!(o instanceof PayDoc))
			return false;
		PayDoc doc = (PayDoc) o;
		return Objects.equals(this.id, PayDoc.id) && Objects.equals(this.DocNum, PayDoc.DocNum);
	}*/

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.DocNum);
	}

	@Override
	public String toString() {
		return "Doc{" + "id=" + this.id + ", docNum'" + this.DocNum + '\'' + '}';
	}
}