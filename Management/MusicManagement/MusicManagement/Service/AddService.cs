using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Service.DAO.VO;
using Service.DAO;
using Service.Util;

namespace Service
{
    public class AddService:Form
    {

        private TextBox txtName;
        private TextBox txtSinger;
        

        BindingList<Music> musics = new BindingList<Music>();

        public AddService(TextBox txtName, TextBox txtSinger)
        {
            this.txtName = txtName;
            this.txtSinger = txtSinger;
        }

        public BindingList<Music> addMusicList(string singer,string name)
        {
            Result rs;
            if (Ragex.isEmpty(name) || Ragex.isEmpty(singer))
                MessageBox.Show("不允许为空", "提示", MessageBoxButtons.OK, MessageBoxIcon.Information);
            else if (Ragex.isSpecial(singer) || Ragex.isSpecial(name))
                MessageBox.Show("不允许特殊字符", "提示", MessageBoxButtons.OK, MessageBoxIcon.Information);
            else if ((rs = HttpUtil.get(URL.SELECT_MUSIC(name, singer))).code != ResCode.OK)
            {
                MessageBox.Show(rs.message, "提示", MessageBoxButtons.OK, MessageBoxIcon.Information);
                txtName.Text = "";
                txtSinger.Text = "";
            }
            else
            {
                Music music = new Music();
                music.musicName = name;
                music.musicSinger = singer;
                musics.Add(music);
            }
            return musics;
        }

        public bool addMusic(BindingList<Music> musics)
        {
            if(musics == null || musics.Count <= 0)
            {
                MessageBox.Show("未添加歌曲", "提示", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return false;
            }
            bool rsb = false;
            try
            {
                Result rs;
                if ((rs = HttpUtil.post(URL.ADD_MUSIC_LIST, musics)).code == ResCode.OK)
                    rsb = true;
            }catch(Exception e)
            {
                Console.WriteLine(e.Message);
                MessageBox.Show("服务器错误", "提示", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            return rsb;
        }
        
    }
}
