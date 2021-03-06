import com.github.bigDataTools.hive.HiveJdbcUtil;
import com.github.bigDataTools.hive.HiveTableManager;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author winston
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TestHiveJdbc {

    //nohup  hive --service hiveserver2 &
    @Test
    public void testQuery()throws  Exception{
        long startTime = System.currentTimeMillis();
        HiveJdbcUtil hiveJdbcUtil = HiveJdbcUtil.getInstance();
        hiveJdbcUtil.setUrl("192.168.130.14","10000");
        hiveJdbcUtil.setUserName("root");
        hiveJdbcUtil.setPassWord("123");
        Connection connection = hiveJdbcUtil.getConnection();
        List<Map<String, Object>> resList = hiveJdbcUtil.querySqlForKeyValue("select * from fz_external_table_withtime");
        //  List<Map<String, Object>> resList = hiveJdbcUtile.id=3, fz_external_table.age=24}
        //{fz_external_table.name=test1, fz_external_table.tel=1111111111, fz_external_table.id=4, fz_external_table.age=22}l.querySqlForKeyValue("select count(*) as totalCount from fz_external_table");
        long endTime = System.currentTimeMillis();
        System.out.println("costTime="+(endTime-startTime));
        resList.stream().forEach(item->{
            System.out.println(item.toString());
        });
    }
}
