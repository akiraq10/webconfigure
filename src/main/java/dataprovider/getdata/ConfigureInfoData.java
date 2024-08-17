package dataprovider.getdata;

public class ConfigureInfoData {
    private String scheme;
    private String domain;
    private  int sesWebPort;
    private  int idpWebPort;
    private String subDirectoryInstall;
    private String kfPath;
    private String kfPWD;
    private String serverName;
    private String dbName;
    private String sqlUserName;
    private String sqlPWD;
    private String idpPublicServerURL;
    private String sesWebPublicServerURL;

    public ConfigureInfoData(String scheme,
                             String domain,
                             int sesWebPort,
                             int idpWebPort,
                             String subDirectoryInstall,
                             String kfPath,
                             String kfPWD,
                             String serverName,
                             String dbName,
                             String sqlUserName,
                             String sqlPWD,
                             String idpPublicServerURL,
                             String sesWebPublicServerURL) {
        this.scheme = scheme;
        this.domain = domain;
        this.sesWebPort = sesWebPort;
        this.idpWebPort = idpWebPort;
        this.subDirectoryInstall = subDirectoryInstall;
        this.kfPath = kfPath;
        this.kfPWD = kfPWD;
        this.serverName = serverName;
        this.dbName = dbName;
        this.sqlUserName = sqlUserName;
        this.sqlPWD = sqlPWD;
        this.idpPublicServerURL = idpPublicServerURL;
        this.sesWebPublicServerURL = sesWebPublicServerURL;
    }

    public String getScheme() {
        return scheme;
    }

    public String getDomain() {
        return domain;
    }

    public int getSesWebPort() {
        return sesWebPort;
    }

    public int getIdpWebPort() {
        return idpWebPort;
    }

    public String getSubDirectoryInstall() {
        return subDirectoryInstall;
    }

    public String getKfPath() {
        return kfPath;
    }

    public String getServerName() {
        return serverName;
    }

    public String getKfPWD() {
        return kfPWD;
    }

    public String getSqlUserName() {
        return sqlUserName;
    }

    public String getDbName() {
        return dbName;
    }

    public String getSqlPWD() {
        return sqlPWD;
    }

    public String getIdpPublicServerURL() {
        return idpPublicServerURL;
    }

    public String getSesWebPublicServerURL() {
        return sesWebPublicServerURL;
    }

}
