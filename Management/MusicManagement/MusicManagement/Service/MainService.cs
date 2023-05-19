using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Service.DAO.VO;
using Service.DAO;
using Service.Util;
using Newtonsoft.Json;

namespace Service
{
    public class MainService
    {

        public BindingList<Music> getDataBinding()
        {
            BindingList<Music> rs = null;
            try
            {
               rs = JsonConvert.DeserializeObject<BindingList<Music>>(HttpUtil.get(URL.GET_ALL_MUSIC).data.ToString());
            }catch(Exception e)
            {
                Console.WriteLine("Service-error from getData");
                Console.WriteLine(e.Message);
            }
            return rs;
        } 

    }
}
