using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Service.DAO;
using System.Net.Http;
using System.Net;
using System.IO;
using Newtonsoft.Json;
using System.Windows.Forms;

namespace Service.Util
{
    public class HttpUtil
    {
        private static readonly HttpClient client = new HttpClient();

        public static Result get(string url)
        {
            Result rs = null;
            try
            {
                HttpWebRequest request = (HttpWebRequest)WebRequest.Create(url);
                request.Method = "GET";
                request.ContentType = "application/json";
                HttpWebResponse response = (HttpWebResponse)request.GetResponse();
                Stream s = response.GetResponseStream();
                
                StreamReader reader = new StreamReader(s, Encoding.UTF8);
                rs = JsonConvert.DeserializeObject<Result>(reader.ReadToEnd());
            }
            catch(Exception e)
            {
                Console.WriteLine("Service-error from Http-Get");
                Console.WriteLine(e.Message);
            }
            return rs;
        }

        public static Result post(string url,object parmas)
        {
            Result rs = null;
            try
            { 
                HttpWebRequest req = (HttpWebRequest)WebRequest.Create(url);
                string json = JsonConvert.SerializeObject(parmas);
                req.Method = "POST";
                req.ContentType = "application/json";
                byte[] data = Encoding.UTF8.GetBytes(json);
                using (Stream stream = req.GetRequestStream())
                {
                    stream.Write(data, 0, data.Length);
                    stream.Close();
                }

                HttpWebResponse resp = (HttpWebResponse)req.GetResponse();
                Stream s = resp.GetResponseStream();
                using (StreamReader streamReader = new StreamReader(s, Encoding.UTF8))
                {
                    rs = JsonConvert.DeserializeObject<Result>(streamReader.ReadToEnd());
                }
            }
            catch(Exception e)
            {
                Console.WriteLine("Service-error from Http-Get");
                Console.WriteLine(e.Message);
            }
            return rs;
        }

        public void DownLoadFileWithProgress(string TargetPath,string url,ProgressBar progress,Label label)
        {
            int bytesProcessed = 0;
            //远程流
            Stream remoteStream = null;
            //本地流
            Stream localStream = null;
            WebResponse resp = null;
            try
            {
                WebRequest req = WebRequest.Create(url);
                if(req != null)
                {
                    double TotalBytesToReceive = 0;
                    var sizeWebReq = HttpWebRequest.Create(new Uri(url));
                    sizeWebReq.Method = "HEAD";
                    using(var webResp = sizeWebReq.GetResponse())
                    {
                        var fileSize = webResp.Headers.Get("Content-Length");
                        TotalBytesToReceive = Convert.ToDouble(fileSize);
                    }
                    resp = req.GetResponse();
                    if(resp != null)
                    {
                        remoteStream = resp.GetResponseStream();
                        string filePath = TargetPath;
                        localStream = File.Create(filePath);
                        byte[] buffer = new byte[1024];
                        int bytesRead = 0;
                        do
                        {
                            bytesRead = remoteStream.Read(buffer, 0, buffer.Length);
                            localStream.Write(buffer, 0, bytesRead);
                            bytesProcessed += bytesRead;

                            double bytesIn = double.Parse(bytesProcessed.ToString());
                            double percentage = bytesIn / TotalBytesToReceive * 100;
                            percentage = Math.Round(percentage, 0);
                            if (progress.InvokeRequired)
                            {
                                progress.Invoke(new Action(() =>
                                    progress.Value = int.Parse(Math.Truncate(percentage).ToString())));
                            }
                            else
                            {
                                progress.Value = int.Parse(Math.Truncate(percentage).ToString());
                            }
                            if (label.InvokeRequired)
                            {
                                label.Invoke(new Action(() =>
                                    label.Text = int.Parse(Math.Truncate(percentage).ToString()).ToString()));
                            }
                            else
                            {
                                label.Text = int.Parse(Math.Truncate(percentage).ToString()).ToString();
                            }
                        } while (bytesRead > 0);
                    }
                }
            }catch(Exception ex)
            {

            }
            finally
            {
                if (resp != null)
                    resp.Close();
                if (remoteStream != null)
                    remoteStream.Close();
                if (localStream != null)
                    localStream.Close();
            }
        }
    }
}
