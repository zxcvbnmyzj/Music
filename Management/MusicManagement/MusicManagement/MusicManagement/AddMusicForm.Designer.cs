
namespace MusicManagement
{
    partial class AddMusicForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.lbl_Singer = new System.Windows.Forms.Label();
            this.txt_Singer = new System.Windows.Forms.TextBox();
            this.txt_MusicName = new System.Windows.Forms.TextBox();
            this.lbl_music = new System.Windows.Forms.Label();
            this.bt_AddList = new System.Windows.Forms.Button();
            this.WaitMusicList_View = new System.Windows.Forms.DataGridView();
            this.bt_submit_list = new System.Windows.Forms.Button();
            this.Add_proBar = new System.Windows.Forms.ProgressBar();
            this.backgroundWorker1 = new System.ComponentModel.BackgroundWorker();
            this.bt_selectMp = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.WaitMusicList_View)).BeginInit();
            this.SuspendLayout();
            // 
            // lbl_Singer
            // 
            this.lbl_Singer.AutoSize = true;
            this.lbl_Singer.Font = new System.Drawing.Font("宋体", 12F);
            this.lbl_Singer.Location = new System.Drawing.Point(33, 42);
            this.lbl_Singer.Name = "lbl_Singer";
            this.lbl_Singer.Size = new System.Drawing.Size(49, 20);
            this.lbl_Singer.TabIndex = 0;
            this.lbl_Singer.Text = "歌手";
            // 
            // txt_Singer
            // 
            this.txt_Singer.Location = new System.Drawing.Point(88, 42);
            this.txt_Singer.Name = "txt_Singer";
            this.txt_Singer.Size = new System.Drawing.Size(161, 25);
            this.txt_Singer.TabIndex = 1;
            // 
            // txt_MusicName
            // 
            this.txt_MusicName.Location = new System.Drawing.Point(88, 102);
            this.txt_MusicName.Name = "txt_MusicName";
            this.txt_MusicName.Size = new System.Drawing.Size(161, 25);
            this.txt_MusicName.TabIndex = 3;
            // 
            // lbl_music
            // 
            this.lbl_music.AutoSize = true;
            this.lbl_music.Font = new System.Drawing.Font("宋体", 12F);
            this.lbl_music.Location = new System.Drawing.Point(33, 102);
            this.lbl_music.Name = "lbl_music";
            this.lbl_music.Size = new System.Drawing.Size(49, 20);
            this.lbl_music.TabIndex = 2;
            this.lbl_music.Text = "歌名";
            // 
            // bt_AddList
            // 
            this.bt_AddList.Font = new System.Drawing.Font("宋体", 12F);
            this.bt_AddList.Location = new System.Drawing.Point(37, 222);
            this.bt_AddList.Name = "bt_AddList";
            this.bt_AddList.Size = new System.Drawing.Size(212, 33);
            this.bt_AddList.TabIndex = 4;
            this.bt_AddList.Text = "加入列表";
            this.bt_AddList.UseVisualStyleBackColor = true;
            this.bt_AddList.Click += new System.EventHandler(this.bt_AddList_Click);
            // 
            // WaitMusicList_View
            // 
            this.WaitMusicList_View.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.WaitMusicList_View.Location = new System.Drawing.Point(297, 27);
            this.WaitMusicList_View.Name = "WaitMusicList_View";
            this.WaitMusicList_View.RowHeadersWidth = 51;
            this.WaitMusicList_View.RowTemplate.Height = 27;
            this.WaitMusicList_View.Size = new System.Drawing.Size(471, 326);
            this.WaitMusicList_View.TabIndex = 5;
            // 
            // bt_submit_list
            // 
            this.bt_submit_list.Font = new System.Drawing.Font("宋体", 12F);
            this.bt_submit_list.Location = new System.Drawing.Point(37, 290);
            this.bt_submit_list.Name = "bt_submit_list";
            this.bt_submit_list.Size = new System.Drawing.Size(212, 33);
            this.bt_submit_list.TabIndex = 6;
            this.bt_submit_list.Text = "提交";
            this.bt_submit_list.UseVisualStyleBackColor = true;
            this.bt_submit_list.Click += new System.EventHandler(this.bt_submit_list_Click);
            // 
            // Add_proBar
            // 
            this.Add_proBar.Location = new System.Drawing.Point(37, 385);
            this.Add_proBar.Name = "Add_proBar";
            this.Add_proBar.Size = new System.Drawing.Size(731, 36);
            this.Add_proBar.TabIndex = 7;
            // 
            // backgroundWorker1
            // 
            this.backgroundWorker1.DoWork += new System.ComponentModel.DoWorkEventHandler(this.backgroundWorker1_DoWork);
            this.backgroundWorker1.RunWorkerCompleted += new System.ComponentModel.RunWorkerCompletedEventHandler(this.backgroundWorker1_RunWorkerCompleted);
            // 
            // bt_selectMp
            // 
            this.bt_selectMp.Font = new System.Drawing.Font("宋体", 12F);
            this.bt_selectMp.Location = new System.Drawing.Point(37, 160);
            this.bt_selectMp.Name = "bt_selectMp";
            this.bt_selectMp.Size = new System.Drawing.Size(212, 33);
            this.bt_selectMp.TabIndex = 8;
            this.bt_selectMp.Text = "导入音频";
            this.bt_selectMp.UseVisualStyleBackColor = true;
            this.bt_selectMp.Click += new System.EventHandler(this.bt_selectMp_Click);
            // 
            // AddMusicForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.bt_selectMp);
            this.Controls.Add(this.Add_proBar);
            this.Controls.Add(this.bt_submit_list);
            this.Controls.Add(this.WaitMusicList_View);
            this.Controls.Add(this.bt_AddList);
            this.Controls.Add(this.txt_MusicName);
            this.Controls.Add(this.lbl_music);
            this.Controls.Add(this.txt_Singer);
            this.Controls.Add(this.lbl_Singer);
            this.Name = "AddMusicForm";
            this.Text = "AddMusicForm";
            this.Load += new System.EventHandler(this.AddMusicForm_Load);
            ((System.ComponentModel.ISupportInitialize)(this.WaitMusicList_View)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lbl_Singer;
        private System.Windows.Forms.TextBox txt_Singer;
        private System.Windows.Forms.TextBox txt_MusicName;
        private System.Windows.Forms.Label lbl_music;
        private System.Windows.Forms.Button bt_AddList;
        private System.Windows.Forms.DataGridView WaitMusicList_View;
        private System.Windows.Forms.Button bt_submit_list;
        private System.Windows.Forms.ProgressBar Add_proBar;
        private System.ComponentModel.BackgroundWorker backgroundWorker1;
        private System.Windows.Forms.Button bt_selectMp;
    }
}