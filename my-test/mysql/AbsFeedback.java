package mysql;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.Date;

@MappedSuperclass
public class AbsFeedback {
	/**
	*	主键
	*/

	protected @Id @GeneratedValue(strategy = GenerationType.IDENTITY) long id = 0;
	/**
	*	
	*/

	protected String no = "";
	/**
	*	备注
	*/

	protected String notes = "";
	/**
	*	创建时间
	*/

	protected Date createTime;
	/**
	*	创建者
	*/

	protected long createUserId = 0;
	/**
	*	更新时间
	*/

	protected Date updateTime;
	/**
	*	更新者
	*/

	protected long updateUserId = 0;
	/**
	*	状态 1有效 0无效 -1作废
	*/

	protected int status = 1;
	/**
	*	姓名
	*/

	protected String name = "";
	/**
	*	版本号
	*/

	@Version
	protected long version = 0;
	/**
	*	
	*/

	protected String type = "";
	/**
	*	
	*/

	protected String content = "";
	/**
	*	
	*/

	protected String telephone = "";

	/**
	*	主键
	*/

	public long getId() {
		return id;
	}

	/**
	*	
	*/

	public String getNo() {
		return no;
	}

	/**
	*	备注
	*/

	public String getNotes() {
		return notes;
	}

	/**
	*	创建时间
	*/

	public Date getCreateTime() {
		return createTime;
	}

	/**
	*	创建者
	*/

	public long getCreateUserId() {
		return createUserId;
	}

	/**
	*	更新时间
	*/

	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	*	更新者
	*/

	public long getUpdateUserId() {
		return updateUserId;
	}

	/**
	*	状态 1有效 0无效 -1作废
	*/

	public int getStatus() {
		return status;
	}

	/**
	*	姓名
	*/

	public String getName() {
		return name;
	}

	/**
	*	版本号
	*/

	public long getVersion() {
		return version;
	}

	/**
	*	
	*/

	public String getType() {
		return type;
	}

	/**
	*	
	*/

	public String getContent() {
		return content;
	}

	/**
	*	
	*/

	public String getTelephone() {
		return telephone;
	}
}
