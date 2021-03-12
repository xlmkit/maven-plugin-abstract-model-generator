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
public class AbsCollection {
protected @Id @GeneratedValue(strategy = GenerationType.IDENTITY) long id = 0;
protected String no = "";
protected String notes = "";
protected Date createTime;
protected long createUserId = 0;
protected Date updateTime;
protected long updateUserId = 0;
protected int status = 1;
protected String name = "";
@Version
protected long version = 0;
protected String url = "";
protected String icon = "";
protected int type = 1;
/**
*	主键
*/

public long getId(){return id;}
/**
*	
*/

public String getNo(){return no;}
/**
*	备注
*/

public String getNotes(){return notes;}
/**
*	创建时间
*/

public Date getCreateTime(){return createTime;}
/**
*	创建者
*/

public long getCreateUserId(){return createUserId;}
/**
*	更新时间
*/

public Date getUpdateTime(){return updateTime;}
/**
*	更新者
*/

public long getUpdateUserId(){return updateUserId;}
/**
*	状态 1有效 0无效 -1作废
*/

public int getStatus(){return status;}
/**
*	姓名
*/

public String getName(){return name;}
/**
*	版本号
*/

public long getVersion(){return version;}
/**
*	
*/

public String getUrl(){return url;}
/**
*	
*/

public String getIcon(){return icon;}
/**
*	类型
1 用户收藏
2 共享
*/

public int getType(){return type;}
}
