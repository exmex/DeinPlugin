/*     */ package me.MrCodex.StatusResponse;
/*     */ 
/*     */ import java.util.List;
/*     */ 
/*     */ public class ServerStatus
/*     */ {
/*     */   private String description;
/*     */   private Players players;
/*     */   private Version version;
/*     */   private String favicon;
/*     */   private int time;
/*     */ 
/*     */   public int hashCode()
/*     */   {
/*  14 */     int PRIME = 59;
/*  15 */     int result = 1;
/*  16 */     Object $description = getDescription();
/*  17 */     result = result * 59 + (
/*  18 */       $description == null ? 0 : $description.hashCode());
/*  19 */     Object $players = getPlayers();
/*  20 */     result = result * 59 + ($players == null ? 0 : $players.hashCode());
/*  21 */     Object $version = getVersion();
/*  22 */     result = result * 59 + ($version == null ? 0 : $version.hashCode());
/*  23 */     Object $favicon = getFavicon();
/*  24 */     result = result * 59 + ($favicon == null ? 0 : $favicon.hashCode());
/*  25 */     result = result * 59 + getTime();
/*  26 */     return result;
/*     */   }
/*     */ 
/*     */   public boolean canEqual(Object other) {
/*  30 */     return other instanceof ServerStatus;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object o) {
/*  34 */     if (o == this) {
/*  35 */       return true;
/*     */     }
/*  37 */     if (!(o instanceof ServerStatus)) {
/*  38 */       return false;
/*     */     }
/*  40 */     ServerStatus other = (ServerStatus)o;
/*  41 */     if (!other.canEqual(this)) {
/*  42 */       return false;
/*     */     }
/*  44 */     Object this$description = getDescription();
/*  45 */     Object other$description = other.getDescription();
/*  46 */     if (this$description == null ? other$description != null : 
/*  47 */       !this$description.equals(other$description)) {
/*  48 */       return false;
/*     */     }
/*  50 */     Object this$players = getPlayers();
/*  51 */     Object other$players = other.getPlayers();
/*  52 */     if (this$players == null ? other$players != null : 
/*  53 */       !this$players
/*  53 */       .equals(other$players)) {
/*  54 */       return false;
/*     */     }
/*  56 */     Object this$version = getVersion();
/*  57 */     Object other$version = other.getVersion();
/*  58 */     if (this$version == null ? other$version != null : 
/*  59 */       !this$version
/*  59 */       .equals(other$version)) {
/*  60 */       return false;
/*     */     }
/*  62 */     Object this$favicon = getFavicon();
/*  63 */     Object other$favicon = other.getFavicon();
/*  64 */     if (this$favicon == null ? other$favicon != null : 
/*  65 */       !this$favicon
/*  65 */       .equals(other$favicon)) {
/*  66 */       return false;
/*     */     }
/*  68 */     return getTime() == other.getTime();
/*     */   }
/*     */ 
/*     */   public String toString() {
/*  72 */     return "StatusResponse(description=" + getDescription() + ", players=" + 
/*  73 */       getPlayers() + ", version=" + getVersion() + ", favicon=" + 
/*  74 */       getFavicon() + ", time=" + getTime() + ")";
/*     */   }
/*     */ 
/*     */   public String getDescription() {
/*  78 */     return this.description;
/*     */   }
/*     */ 
/*     */   public void setDescription(String description) {
/*  82 */     this.description = description;
/*     */   }
/*     */ 
/*     */   public Players getPlayers() {
/*  86 */     return this.players;
/*     */   }
/*     */ 
/*     */   public void setPlayers(Players players) {
/*  90 */     this.players = players;
/*     */   }
/*     */ 
/*     */   public Version getVersion() {
/*  94 */     return this.version;
/*     */   }
/*     */ 
/*     */   public void setVersion(Version version) {
/*  98 */     this.version = version;
/*     */   }
/*     */ 
/*     */   public String getFavicon() {
/* 102 */     return this.favicon;
/*     */   }
/*     */ 
/*     */   public void setFavicon(String favicon) {
/* 106 */     this.favicon = favicon;
/*     */   }
/*     */ 
/*     */   public void setTime(int time) {
/* 110 */     this.time = time;
/*     */   }
/*     */ 
/*     */   public int getTime() {
/* 114 */     return this.time;
/*     */   }
/*     */ 
/*     */   public class Player
/*     */   {
/*     */     private String name;
/*     */     private String id;
/*     */ 
/*     */     public boolean equals(Object o)
/*     */     {
/* 198 */       if (o == this) {
/* 199 */         return true;
/*     */       }
/* 201 */       if (!(o instanceof Player)) {
/* 202 */         return false;
/*     */       }
/* 204 */       Player other = (Player)o;
/* 205 */       if (!other.canEqual(this)) {
/* 206 */         return false;
/*     */       }
/* 208 */       Object this$name = getName();
/* 209 */       Object other$name = other.getName();
/* 210 */       if (this$name == null ? other$name != null : 
/* 211 */         !this$name
/* 211 */         .equals(other$name)) {
/* 212 */         return false;
/*     */       }
/* 214 */       Object this$id = getId();
/* 215 */       Object other$id = other.getId();
/* 216 */       return this$id == null ? false : other$id == null ? true : this$id
/* 217 */         .equals(other$id);
/*     */     }
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 222 */       int PRIME = 59;
/* 223 */       int result = 1;
/* 224 */       Object $name = getName();
/* 225 */       result = result * 59 + ($name == null ? 0 : $name.hashCode());
/* 226 */       Object $id = getId();
/* 227 */       result = result * 59 + ($id == null ? 0 : $id.hashCode());
/* 228 */       return result;
/*     */     }
/*     */ 
/*     */     public boolean canEqual(Object other) {
/* 232 */       return other instanceof Player;
/*     */     }
/*     */ 
/*     */     public String toString() {
/* 236 */       return "StatusResponse.Player(name=" + getName() + ", id=" + 
/* 237 */         getId() + ")";
/*     */     }
/*     */ 
/*     */     public void setName(String name) {
/* 241 */       this.name = name;
/*     */     }
/*     */ 
/*     */     public String getName() {
/* 245 */       return this.name;
/*     */     }
/*     */ 
/*     */     public void setId(String id) {
/* 249 */       this.id = id;
/*     */     }
/*     */ 
/*     */     public String getId() {
/* 253 */       return this.id;
/*     */     }
/*     */ 
/*     */     public Player()
/*     */     {
/*     */     }
/*     */   }
/*     */ 
/*     */   public class Players
/*     */   {
/*     */     private int max;
/*     */     private int online;
/*     */     private List<ServerStatus.Player> sample;
/*     */ 
/*     */     public boolean canEqual(Object other)
/*     */     {
/* 123 */       return other instanceof Players;
/*     */     }
/*     */ 
/*     */     public boolean equals(Object o) {
/* 127 */       if (o == this) {
/* 128 */         return true;
/*     */       }
/* 130 */       if (!(o instanceof Players)) {
/* 131 */         return false;
/*     */       }
/* 133 */       Players other = (Players)o;
/* 134 */       if (!other.canEqual(this)) {
/* 135 */         return false;
/*     */       }
/* 137 */       if (getMax() != other.getMax()) {
/* 138 */         return false;
/*     */       }
/* 140 */       if (getOnline() != other.getOnline()) {
/* 141 */         return false;
/*     */       }
/* 143 */       Object this$sample = getSample();
/* 144 */       Object other$sample = other.getSample();
/* 145 */       return this$sample == null ? false : other$sample == null ? true : this$sample
/* 146 */         .equals(other$sample);
/*     */     }
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 151 */       int PRIME = 59;
/* 152 */       int result = 1;
/* 153 */       result = result * 59 + getMax();
/* 154 */       result = result * 59 + getOnline();
/* 155 */       Object $sample = getSample();
/* 156 */       result = result * 59 + ($sample == null ? 0 : $sample.hashCode());
/* 157 */       return result;
/*     */     }
/*     */ 
/*     */     public String toString() {
/* 161 */       return "StatusResponse.Players(max=" + getMax() + ", online=" + 
/* 162 */         getOnline() + ", sample=" + getSample() + ")";
/*     */     }
/*     */ 
/*     */     public void setMax(int max) {
/* 166 */       this.max = max;
/*     */     }
/*     */ 
/*     */     public int getMax() {
/* 170 */       return this.max;
/*     */     }
/*     */ 
/*     */     public void setOnline(int online) {
/* 174 */       this.online = online;
/*     */     }
/*     */ 
/*     */     public int getOnline() {
/* 178 */       return this.online;
/*     */     }
/*     */ 
/*     */     public List<ServerStatus.Player> getSample() {
/* 182 */       return this.sample;
/*     */     }
/*     */ 
/*     */     public void setSample(List<ServerStatus.Player> sample) {
/* 186 */       this.sample = sample;
/*     */     }
/*     */ 
/*     */     public Players()
/*     */     {
/*     */     }
/*     */   }
/*     */ 
/*     */   public class Version
/*     */   {
/*     */     private String name;
/*     */     private String protocol;
/*     */ 
/*     */     public boolean equals(Object o)
/*     */     {
/* 265 */       if (o == this) {
/* 266 */         return true;
/*     */       }
/* 268 */       if (!(o instanceof Version)) {
/* 269 */         return false;
/*     */       }
/* 271 */       Version other = (Version)o;
/* 272 */       if (!other.canEqual(this)) {
/* 273 */         return false;
/*     */       }
/* 275 */       Object this$name = getName();
/* 276 */       Object other$name = other.getName();
/* 277 */       if (this$name == null ? other$name != null : 
/* 278 */         !this$name
/* 278 */         .equals(other$name)) {
/* 279 */         return false;
/*     */       }
/* 281 */       Object this$protocol = getProtocol();
/* 282 */       Object other$protocol = other.getProtocol();
/* 283 */       return this$protocol == null ? false : other$protocol == null ? true : 
/* 284 */         this$protocol.equals(other$protocol);
/*     */     }
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 289 */       int PRIME = 59;
/* 290 */       int result = 1;
/* 291 */       Object $name = getName();
/* 292 */       result = result * 59 + ($name == null ? 0 : $name.hashCode());
/* 293 */       Object $protocol = getProtocol();
/* 294 */       result = result * 59 + (
/* 295 */         $protocol == null ? 0 : $protocol.hashCode());
/* 296 */       return result;
/*     */     }
/*     */ 
/*     */     public boolean canEqual(Object other) {
/* 300 */       return other instanceof Version;
/*     */     }
/*     */ 
/*     */     public String toString() {
/* 304 */       return "StatusResponse.Version(name=" + getName() + ", protocol=" + 
/* 305 */         getProtocol() + ")";
/*     */     }
/*     */ 
/*     */     public void setName(String name) {
/* 309 */       this.name = name;
/*     */     }
/*     */ 
/*     */     public String getName() {
/* 313 */       return this.name;
/*     */     }
/*     */ 
/*     */     public void setProtocol(String protocol) {
/* 317 */       this.protocol = protocol;
/*     */     }
/*     */ 
/*     */     public String getProtocol() {
/* 321 */       return this.protocol;
/*     */     }
/*     */ 
/*     */     public Version()
/*     */     {
/*     */     }
/*     */   }
/*     */ }