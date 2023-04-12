package com.supermap.msdelete.utils;

public enum SphFileInfo {
	FILESEQ{
		@Override
		public String toString() {
			return "fileSeq";
		}
	},
	FILEPATH{
		@Override
		public String toString() {
			return "filePath";
		}
	},
	FILEFLAG{
		@Override
		public String toString() {
			return "fileFlag";
		}
	},
	FILETYPE{
		//FILETYPE -> shp, kmz, kml
		@Override
		public String toString() {
			return "fileType";
		}
	},
	FILENAME{
		@Override
		public String toString() {
			return "fileName";
		}
	},
	BANDINDEXS{
		@Override
		public String toString() {
			return "bandIndexs";
		}
	},
}
