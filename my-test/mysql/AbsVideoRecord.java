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
public class AbsVideoRecord {
protected @Id @GeneratedValue(strategy = GenerationType.IDENTITY) long id = 0;
protected Date createTime;
protected long createUserId = 0;
protected Date updateTime;
protected long updateUserId = 0;
protected int status = 1;
protected BigDecimal duration = BigDecimal.ZERO;
@Version
protected long version = 0;
protected BigDecimal currentTime = BigDecimal.ZERO;
protected String ip = "";
protected String guid = "";
protected String ipInfo = "";
protected long videoId = 0;
protected boolean firstSign = false;
/**
*	主键
*/

public long getId(){return id;}
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

public BigDecimal getDuration(){return duration;}
/**
*	版本号
*/

public long getVersion(){return version;}
/**
*	
*/

public BigDecimal getCurrentTime(){return currentTime;}
/**
*	
*/

public String getIp(){return ip;}
/**
*	
*/

public String getGuid(){return guid;}
/**
*	
*/

public String getIpInfo(){return ipInfo;}
/**
*	
*/

public long getVideoId(){return videoId;}
/**
*	
*/

public boolean getFirstSign(){return firstSign;}
}
