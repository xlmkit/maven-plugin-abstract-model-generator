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
public class AbsVideo {
protected @Id @GeneratedValue(strategy = GenerationType.IDENTITY) long id = 0;
protected Date createTime;
protected long createUserId = 0;
protected Date updateTime;
protected long updateUserId = 0;
protected int status = 1;
protected String name = "";
@Version
protected long version = 0;
protected String brand = "";
protected String path = "";
protected String no = "";
protected String playUrl = "";
protected String parser = "";
protected String origin = "";
protected String parseResult = "";
protected String website = "";
protected int playCount = 0;
protected int quality = 0;
protected int readyCount = 0;
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

public String getName(){return name;}
/**
*	版本号
*/

public long getVersion(){return version;}
/**
*	
*/

public String getBrand(){return brand;}
/**
*	
*/

public String getPath(){return path;}
/**
*	
*/

public String getNo(){return no;}
/**
*	
*/

public String getPlayUrl(){return playUrl;}
/**
*	
*/

public String getParser(){return parser;}
/**
*	
*/

public String getOrigin(){return origin;}
/**
*	
*/

public String getParseResult(){return parseResult;}
/**
*	
*/

public String getWebsite(){return website;}
/**
*	
*/

public int getPlayCount(){return playCount;}
/**
*	
*/

public int getQuality(){return quality;}
/**
*	
*/

public int getReadyCount(){return readyCount;}
}
