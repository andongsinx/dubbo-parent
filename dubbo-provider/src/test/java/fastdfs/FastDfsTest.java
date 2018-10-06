package fastdfs;

import com.dubbo.provider.utils.FastDfsUtils;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @description
 * @create by shadow
 * @date 2018/7/6
 * @since 1.0
 */
public class FastDfsTest {


    private String conf_filename = "src/main/resources/fdfs_client.conf";

    private String local_filename = "F:\\ideaProject\\rpc\\dubbo-parent\\dubbo-provider\\src\\main\\resources\\img\\test.JPG";


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testUpload() throws FileNotFoundException {

        /*try {
            ClientGlobal.init(conf_filename);
            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            StorageServer storageServer = null;

            StorageClient storageClient = new StorageClient(trackerServer,storageServer);


            NameValuePair[] nvp = new NameValuePair[]{
                    new NameValuePair("age", "18"),
                    new NameValuePair("sex", "male")
            };

            String[] fileIds = storageClient.upload_file(local_filename,"jpg",nvp);
            System.out.println(fileIds.length);
            System.out.println("组名：" + fileIds[0]);
            System.out.println("路径: " + fileIds[1]);



        }catch (Exception e){
            e.printStackTrace();
        }


*/
        InputStream is = new FileInputStream(local_filename);

        String result = FastDfsUtils.uploadFile(new File(local_filename), "halajhl.jpg");
        System.out.println(result);
       // int i = FastDfsUtils.downloadFile("group1/M00/00/00/rBEkhFs_c4uAUbc0AAHEfkTRBnk665.jpg", new File("f:/a.jpg"));
        //System.out.println(i);


    }

}
