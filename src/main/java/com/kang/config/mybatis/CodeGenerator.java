package com.kang.config.mybatis;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * <p>Title: CodeGenerator</p>
 * <p>Description: Mybatis plus逆向工程代码生成器<p>
 * @author ChaoKang
 * @date 2020年6月4日
 */
public class CodeGenerator {

    public static void main(String[] args) {

        //1、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "\\src\\main\\java")//文件输出路径
                .setAuthor("chaokang") //作者
                .setOpen(false) //生成完成是否打开文件夹
                .setFileOverride(true) //是否覆写
                .setIdType(IdType.AUTO) //主键策略
                .setEnableCache(false) //是否启用缓存
                .setServiceName("%sService") //生成service前缀不带I
                .setBaseResultMap(true) //生成result 映射
                .setSwagger2(true) //是否启动swagger
                .setBaseColumnList(true); //生成公众的sql字段

        //2、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl("jdbc:mysql://47.105.189.247:3306/jyweb?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8")
                .setUsername("root")
                .setPassword("123456")
                .setTypeConvert(new MySqlTypeConvert() {
                	@Override
                	public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
						if(fieldType.toLowerCase().contains("tinyint")) {
							return DbColumnType.BOOLEAN;
						}
						if(fieldType.toLowerCase().contains("datetime")) {
							return DbColumnType.DATE;
						}
						if(fieldType.toLowerCase().contains("date")) {
							return DbColumnType.DATE;
						}
                		return super.processTypeConvert(globalConfig, fieldType);
                	}
                });

        //3、策略配置
        StrategyConfig sc = new StrategyConfig();
        sc.setCapitalMode(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setEntityLombokModel(true)
                .setTablePrefix("tb_")
                .setRestControllerStyle(true)
                .setInclude("tb_user");

        //4、包名策略配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.kang")
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("model")
                .setXml("mapper");
        

        //5、 整合配置
        AutoGenerator ag = new AutoGenerator();
        ag.setGlobalConfig(gc)
                .setDataSource(dsc)
                .setStrategy(sc)
                .setPackageInfo(pc)
                .execute();
    }
}


