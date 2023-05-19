using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.DAO.VO
{
    public class Music
    {
        private int Id;

        private string MusicName;

        private string MusicSinger;

        public int id { get => Id; set => Id = value; }
        public string musicName { get => MusicName; set => MusicName = value; }
        public string musicSinger { get => MusicSinger; set => MusicSinger = value; }
    }
}
