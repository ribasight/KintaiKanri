
public class Model {

	private String yyyymm;
	private String lastday;


	/**
	 * 年月を取得します
	 * @return
	 */
	public String getYyyymm() {
		return yyyymm;
	}

	/**
	 * 年月を設定します
	 * @param yyyymm
	 */
	public void setYyyymm(String yyyymm) {
		this.yyyymm = yyyymm;
	}

	/**
	 * 月末を取得します
	 * @return lastday 月末
	 */
	public String getLastday() {
		return lastday;
	}

	/**
	 * 月末を設定します
	 * @param yyyymm
	 */
	public void setLastday(String lastday) {
		this.lastday = lastday;
	}
}
