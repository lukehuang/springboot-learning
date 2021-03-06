package com.rtxtitanv.model

import javax.persistence.*

/**
 * @name com.rtxtitanv.model.Account
 * @description 账户实体类 OneToMany 一对多的一方
 * @author rtxtitanv
 * @date 2020/1/20 21:08
 * @version v1.0.0
 */
@Entity
@Table(name = "account")
class Account(@Id
              @GeneratedValue(strategy = GenerationType.IDENTITY)
              @Column(name = "account_id")
              var accountId: Long? = null,
              @Column(name = "account_name", unique = true, nullable = false)
              var accountName: String? = null,
              @Column(name = "account_password", nullable = false)
              var accountPassword: String? = null,
              @Column(name = "account_alias")
              var accountAlias: String? = null,
              @Column(name = "account_addr")
              var accountAddr: String? = null,
              @Column(name = "account_tel", unique = true, nullable = false)
              var accountTel: String? = null,
              @Column(name = "account_rank", nullable = false)
              var accountRank: Long? = null,
              @Column(name = "ccount_location", nullable = false)
              var accountLocation: String? = null,
              @OneToMany(mappedBy = "account", //引用在多方实体类中一方实体类对象名称，一方放弃维护外键关系
                      // CascadeType为级联设置：操作一个对象同时操作它的关联对象
                      // PERSIST：保存，REFRESH：刷新，MERGE：合并，REMOVE：删除
                      //FetchType：设置加载方式，LAZY：延迟加载，EAGER：立即加载
                      //orphanRemoval：是否使用孤儿删除，即在一方关联多方的集合中移除的多方记录将
                      //成为孤儿，没有与一方任何一条记录关联，此时会自动删除这些多方记录，true：使用，false：不使用
                      cascade = [CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.REMOVE],
                      fetch = FetchType.LAZY, orphanRemoval = true)
              //这里需要声明为可变集合MutableSet，MutableSet是一个带有来自MutableCollection的写操作接口的Set
              var orders: MutableSet<Order> = HashSet()) {

    override fun toString(): String {
        return "Account{" +
                "accountId=$accountId" +
                ", accountName='$accountName'" +
                ", accountPassword='$accountPassword'" +
                ", accountAlias='$accountAlias'" +
                ", accountAddr='$accountAddr'" +
                ", accountTel='$accountTel'" +
                ", accountRank=$accountRank" +
                ", accountLocation='$accountLocation'" +
                "}"
    }
}